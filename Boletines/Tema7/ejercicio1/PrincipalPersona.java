package Tema7.ejercicio1;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class PrincipalPersona {

    public static void main(String[] args) {
        Persona miguel = new Persona("miguel", "29640128k", "697434567", "02/11/2003");
        Persona jose = new Persona("jose", "29693128k", "696544567", "23/06/2004");
        Persona ana = new Persona("ana", "23840128k", "690614567", "01/12/1998");
        Persona paco = new Persona("paco", "26947528k", "697496657", "20/04/2022");

        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(miguel);
        personas.add(jose);
        personas.add(ana);
        personas.add(paco);

        File f = new File("Boletines/Tema7/ejercicio1/personas.xml");

        try {
            //DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Document documento = db.newDocument();
            //Es lo mismo que:
            Document documento = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            //Creo el elemento raiz:
            Element raiz = documento.createElement("personas");

            //Añado al documento XML el elemento raiz "persona":
            documento.appendChild(raiz);

            //for que recorre la coleccion de personas:
            for (Persona p : personas) {
                Element persona = documento.createElement("persona");
                raiz.appendChild(persona);

                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(p.getNombre());
                persona.appendChild(nombre);

                Element dni = documento.createElement("dni");
                persona.appendChild(dni);

                Element telefono = documento.createElement("telefono");
                persona.appendChild(telefono);

                Element fechaNacimiento = documento.createElement("fechaNacimiento");
                persona.appendChild(fechaNacimiento);
            }

        } catch (ParserConfigurationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }


    }
}
