package Tema7.Boletin7p3.ejercicio3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ej3 {
    public static void main(String[] args) {

        File f = new File("Boletines/Tema7/Boletin7p3/ejercicio3/desayuno.xml");

        try {
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

            NodeList comida = documento.getElementsByTagName("food");

            //Mostramos los platos de menos de 5€
            System.out.println("---------------");
            System.out.println("Platos de menos de 5€");

            for (int i = 0; i < comida.getLength(); i++) {
                Element plato = (Element) comida.item(i);
                Element precio = (Element) plato.getElementsByTagName("price").item(0);
                //Cambiamos las "," por puntos en los precios ya que hay de los dos tipos y Double solo acepta el punto.
                double precioPlatos = Double.parseDouble(precio.getTextContent().substring(0, (precio.getTextContent().length() - 1)).replace(",", "."));
                if (precioPlatos < 5) {
                    System.out.println(plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }

            //Mostramos los platos de menos de 500 calorias:
            System.out.println("---------------");
            System.out.println("Platos de menos de 500 calorías:");

            for (int i = 0; i < comida.getLength(); i++) {
                Element plato = (Element) comida.item(i);
                String caloriasPlato = plato.getElementsByTagName("calories").item(0).getTextContent();
                int calorias = Integer.parseInt(caloriasPlato);
                if (calorias <= 500) {
                    System.out.println(plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }

            //Añadiremos  a cada plato un atributo, con un identificador numérico comenzando en 1,
            //desde el primero al último (desc.)

            for (int i = 0; i < comida.getLength(); i++) {
                Element plato = (Element) comida.item(i);
                // Añado a cada elemento <food> un nuevo atributo llamado id el cual se auto incrementa.
                plato.setAttribute("id", String.valueOf(i + 1));
            }

            //Declara la ruta del fichero destino
            File destino = new File("Boletines/Tema7/Boletin7p3/ejercicio3/nuevoDesayuno.xml");
            //Crea el transformador
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //Va indentando los elementos
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //Indica de donde proviene la informacion para que el transformador  pueda leer el documento
            DOMSource source = new DOMSource(documento);
            //Indica el fichero destino
            StreamResult result = new StreamResult(destino);
            //Transforma el documento al resultado
            transformer.transform(source, result);


            Element platoNuevo = documento.createElement("food)");
            documento.appendChild(platoNuevo);

            Element nombre = documento.createElement("name");
            nombre.appendChild(documento.createTextNode("Gambas al ajillo"));
            platoNuevo.appendChild(nombre);

            Element price = documento.createElement("price");
            price.appendChild(documento.createTextNode("8,50€"));
            platoNuevo.appendChild(price);

            Element descripcion = documento.createElement("description");
            descripcion.appendChild(documento.createTextNode("Gambas con ajo y cozas"));
            platoNuevo.appendChild(descripcion);
            //TODO



        } catch (ParserConfigurationException | SAXException | IOException | RuntimeException | TransformerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }



    }
}
