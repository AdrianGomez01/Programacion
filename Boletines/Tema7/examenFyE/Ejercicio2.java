package Tema7.examenFyE;

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


public class Ejercicio2 {

    // año de emision
    private static final int ANHO_MIN_EMISION = 1992;
    //ARCHIVO XML CON LOS CAPIS DE LOS SIMPSONS
    static File f = new File("Boletines/Tema7/examenFyE/simpsons.xml");

    public static void main(String[] args) {

        metodo1();

        metodo2();

        metodo3();
    }

    public static void metodo1() {

        try {
            //Creamos el objeto documento
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

            //Obtenemos el nodo raíz
            NodeList capitulos = documento.getElementsByTagName("capitulo");

            //Recorremos los nodos y vamos a buscar lo que se nos pide en el ejercicio, el nombre y fecha de emisión de los episodios
            // emitidos a posteriori del año 1992
            for (int i = 0; i < capitulos.getLength(); i++) {
                Element capitulo = (Element) capitulos.item(i);
                Element emision = (Element) capitulo.getElementsByTagName("fecha_emision").item(0);

                //Saco la fecha completa de la emision y de ésta extraigo los 4 últimos carácteres que son el año para pooder compararlo.
                String fechaEmision = emision.getTextContent();
                String anhoEmision = "";

                if (fechaEmision.length() > 4) {
                    anhoEmision = fechaEmision.substring(fechaEmision.length() - 4);
                } else {
                    anhoEmision = fechaEmision;
                }

                // Comparo que el año de emision sea superior al que piden, creado con en una constante arriba.
                // Si es así escribo la fecha y el nombre completo del capitulo .

                if (ANHO_MIN_EMISION <= Integer.parseInt(anhoEmision)) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Capitulo: " + capitulo.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Fecha de emision: " + capitulo.getElementsByTagName("fecha_emision").item(0).getTextContent());
                }

            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static void metodo2() {

        Document newDocument = null;
        try {
            //Creamos el objeto documento
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
            //Obtenemos el nodo raíz
            NodeList capitulos = documento.getElementsByTagName("capitulo");

            //Recorremos la lista de nodos
            for (int i = 0; i < capitulos.getLength(); i++) {
                Element capitulo = (Element) capitulos.item(i);
                String sinopsis = capitulo.getElementsByTagName("sinopsis").item(0).getTextContent();

                //Con esto saco el num de palabras que tiene la sinopsis
                int numPalabras = 0;
                if (sinopsis == null || sinopsis.isEmpty()) {
                    System.out.println("La sinopsis está vacía");
                } else {
                    String[] palabras = sinopsis.split("\\s+");
                    numPalabras = palabras.length;
                }
                //Compruebo si tiene menos de 30 palabras, si es así elimino el capitulo.
                if (numPalabras < 30) {
                    capitulo.getParentNode().removeChild(capitulo);
                    i--;
                }
            }

            // Creamos un nuevo documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            newDocument = builder.newDocument();
            // Copiar el nodo raíz del documento original al nuevo documento
            Node root = newDocument.importNode(documento.getDocumentElement(), true);
            newDocument.appendChild(root);


            // Guardo el archivo XML
            File f = new File("Boletines/Tema7/examenFyE/sinopsisMas30.xml");
            // Escribir el nuevo documento en un archivo XML
            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException e) {
                System.err.println("Error al crear el transformador: " + e.getMessage());
            }
            if (transformer != null) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            } else {
                System.out.println("Error, el transformador es null");
            }

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(f);
            try {
                if (transformer != null) {
                    transformer.transform(source, result);
                } else {
                    System.out.println("Error, el transformador es null");
                }
            } catch (TransformerException e) {
                System.err.println("Error al escribir el archivo XML: " + e.getMessage());
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

    }

    public static void metodo3() {
        Document newDocument = null;
        try {
            //Creamos el objeto documento
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
            //Obtenemos el nodo raíz
            NodeList capitulos = documento.getElementsByTagName("capitulo");

            //Recorremos la lista de nodos y reeemplazamos las pabaras que deseamos.
            for (int i = 0; i < capitulos.getLength(); i++) {
                Element capitulo = (Element) capitulos.item(i);
                Element sinopsis = (Element) capitulo.getElementsByTagName("sinopsis").item(0);
                String sinopsisCambiada = sinopsis.getTextContent()
                        .replace("[B-b][A-a][R-r][T-t]", "**Bart**")
                        .replace("Lisa", "**Lisa**")
                        .replace("Marge", "**Marge**")
                        .replace("Maggie", "**Maggie**")
                        .replace("Homer", "**Homer**");
            }



            // Creamos un nuevo documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            newDocument = builder.newDocument();
            // Copiar el nodo raíz del documento original al nuevo documento
            Node root = newDocument.importNode(documento.getDocumentElement(), true);
            newDocument.appendChild(root);


            // Guardo el archivo XML
            File f = new File("Boletines/Tema7/examenFyE/simpsonsConAsteriscos.xml");
            // Escribir el nuevo documento en un archivo XML
            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException e) {
                System.err.println("Error al crear el transformador: " + e.getMessage());
            }
            if (transformer != null) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            } else {
                System.out.println("Error, el transformador es null");
            }

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(f);
            try {
                if (transformer != null) {
                    transformer.transform(source, result);
                } else {
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
