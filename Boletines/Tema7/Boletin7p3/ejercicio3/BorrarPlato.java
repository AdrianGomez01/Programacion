package Tema7.Boletin7p3.ejercicio3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class BorrarPlato {

    public static void main(String[] args) {

        File archivo = new File("Boletines/Tema7/Boletin7p3/ejercicio3/desayuno.xml");

        Document newDocument = null;
        try {
            //Creamos el objeto documento
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(archivo);
            //Obtenemos el nodo raíz
            NodeList comida = documento.getElementsByTagName("food");
            //Recorremos la lista de nodos
            int numPlatos = comida.getLength();
            for (int i = 0; i < comida.getLength(); i++) {
                Element food = (Element) comida.item(i);
                String plato = food.getElementsByTagName("calories").item(0).getTextContent();
                int calorias = Integer.parseInt(plato);
                if (calorias > 500) {
                    food.getParentNode().removeChild(food);
                    i--;
                }
            }

            // Borramos los platos que tengan más de 500 calorías
            // Creamos un nuevo documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            newDocument = builder.newDocument();
            // Copiar el nodo raíz del documento original al nuevo documento
            Node root = newDocument.importNode(documento.getDocumentElement(), true);
            newDocument.appendChild(root);


            // Guardar el archivo XML

            File f = new File("Boletines/Tema7/Boletin7p3/ejercicio3/desayunoSaludable.xml");
            // Escribir el nuevo documento en un archivo XML
            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException e) {
                System.err.println("Error al crear el transformador: " + e.getMessage());
            }
            if (transformer != null) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }else {
                System.out.println("Error, el transformador es null");
            }

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(f);
            try {
                if (transformer != null) {
                    transformer.transform(source, result);
                }else {
                    System.out.println("Error, el transformador es null");
                }
            } catch (TransformerException e) {
                System.err.println("Error al escribir el archivo XML: " + e.getMessage());
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}