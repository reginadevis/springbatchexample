package com.scheduled.tasks;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.scheduled.config.AppConfig;
import com.scheduled.pojo.ApplicationProperties;
import com.scheduled.pojo.PojoXML;
 
public class TaskOne implements Tasklet {
 
	public static String filePath;

	public static String fileName;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception 
    {
        System.out.println("TaskOne start..");
     
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationProperties appProperties = context.getBean(ApplicationProperties.class);
     
        filePath = appProperties.getFilePath();
        fileName = appProperties.getFileName();
        String completeFileName = filePath + fileName;
        
        
        PojoXML pojoXML = new PojoXML(1,"Tom",123.45);
       
        jaxbObjectToXML(pojoXML,completeFileName);
        
        System.out.println("TaskOne done..");
        return RepeatStatus.FINISHED;
    } 
    
    private static void jaxbObjectToXML(PojoXML pojoXML, String completeFileName)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(PojoXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File(completeFileName);
            jaxbMarshaller.marshal(pojoXML, file); 
        } 
        catch (JAXBException e) 
        {
            e.printStackTrace();
        }
    }
}