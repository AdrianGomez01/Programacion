package Tema7.Boletin7p3.ejercicio2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ej2 {

    public static void main(String[] args) {

        File f = new File("Boletines/Tema7/ejercicio2/web1.html");

        try {
            //Creamos el documento y transformamos con parse. parse tambien lo lee.
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);

            //Imprimimos por pantalla el título de la página seleccionando directamente la etiqueta del elemento que queremos (title).
            System.out.println("El título de la página es: " + documento.getElementsByTagName("title").item(0).getTextContent());

            //Sacamos el elemento raiz  <html> (No la hemos usado al final.
            // Element raiz = documento.getDocumentElement();

            //contamos cuantos divisores tiene
            System.out.println("Existen: " + documento.getElementsByTagName("div").getLength() + " divisores");

            //creamos un contador para ir contando el numero de div con calor en su id
            int contador = 0;
            //Creamos una lista de nodos con todos los div
            NodeList listaDiv = documento.getElementsByTagName("div");

            //Recorremos la lista
            for (int i = 0; i < listaDiv.getLength(); i++) {
                //Creamos un elemento Div para comprobar sus atributos
                Element div = (Element) listaDiv.item(i);
                //Comprueba aue el div tiene id y no está vacío
                if (div.hasAttribute("id") && !div.getAttribute("id").isEmpty()) {
                    contador++;
                }
            }
            System.out.println("Existen " + contador + " div con id");

            //Ahora mostraremos el texto alternativo de las imagenes del cocumento.
            NodeList listImg = documento.getElementsByTagName("img");
            for (int i = 0; i < listImg.getLength(); i++) {
                //Creamos un elemento img para comprobar sus atributos
                Element img = (Element) listImg.item(i);
                //Comprueba la img tiene texto alternativo y que no está vacío
                if (img.hasAttribute("alt") && !img.getAttribute("alt").isEmpty()) {
                    System.out.println("El texto alternativo de la imagen es: " + img.getAttribute("alt"));
                }
            }


            //Ahora mostraremos los titulares de las noticias que haya en la pagina y el texto alternativo de las imagenes que las acompañan.
            for (int i = 0; i < listaDiv.getLength(); i++) {
                Element div = (Element) listaDiv.item(i);
                if (div.hasAttribute("class") && div.getAttribute("class").equals("noticia")) {
                    String titular = div.getElementsByTagName("h2").item(0).getTextContent();
                    String textoImg = div.getElementsByTagName("img").item(0).getAttributes().getNamedItem("alt").getTextContent();
                    System.out.println("---------------");
                    System.out.println("El texto del titular es: " + titular);
                    System.out.println("El texto de la img es: " + textoImg);
                }
            }

            //Mostramos los titulares y el texto de la noticia:
            for (int i = 0; i < listaDiv.getLength(); i++) {
                Element div = (Element) listaDiv.item(i);
                if (div.hasAttribute("class") && div.getAttribute("class").equals("noticia")) {
                    String titular = div.getElementsByTagName("h2").item(0).getTextContent();
                    String textoNoticia = div.getElementsByTagName("p").item(0).getTextContent();
                    System.out.println("---------------");
                    System.out.println("El texto del titular es: " + titular);
                    System.out.println("El texto de la noticia es: " + textoNoticia);
                }
            }

            //Mostramos el menú:
            for (int i = 0; i < listaDiv.getLength(); i++) {
                Element div = (Element) listaDiv.item(i);
                if (div.hasAttribute("id") && div.getAttribute("id").equals("menu-principal")) {
                    NodeList ListaOpciones = div.getElementsByTagName("li");
                    System.out.println("---------------");
                    System.out.println("Menú");
                    for (int j = 0; j < ListaOpciones.getLength(); j++) {
                        System.out.println(ListaOpciones.item(j).getTextContent());
                    }
                    break;
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
