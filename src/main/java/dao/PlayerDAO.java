package main.java.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import main.java.model.Player;

public class PlayerDAO {
	
	private static final String File = "src/main/resources/Player.xml";
	
    public static Player jaxbXMLToObject() {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Player.class);
//            Unmarshaller un = context.createUnmarshaller();
//            Player player = (Player) un.unmarshal(new File(File));
//            return player;
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        return null;
    }


    public static void jaxbObjectToXML(Player player) {

//        try {
//            JAXBContext context = JAXBContext.newInstance(Player.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            m.marshal(player, new File(File));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }

}
