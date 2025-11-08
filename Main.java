import javax.swing.ImageIcon;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

class Iconos {
  public static final ImageIcon Personaje = new ImageIcon(Iconos.class.getResource("/imagenes/pj.png"));
  public static final ImageIcon Boris = new ImageIcon(Iconos.class.getResource("/imagenes/Boris.png"));
  public static final ImageIcon Mikhail = new ImageIcon(Iconos.class.getResource("/imagenes/Mikhail.png"));
  public static final ImageIcon Alexei = new ImageIcon(Iconos.class.getResource("/imagenes/Alexei.png"));
  public static final ImageIcon Biblioteca = new ImageIcon(Iconos.class.getResource("/imagenes/Biblioteca.png"));
  public static final ImageIcon Boris_duda = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_duda.png"));
  public static final ImageIcon Boris_Mano = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_Mano.png"));
}

class Salas {
  Inventario inventario = new Inventario();
  boolean opTable = false;

  public int sala0(int puntaje, int salaActual) {

    String Texto_sala0;

    if (opTable) {
      Texto_sala0 = "Que decides hacer?\n"
          + "1. observar bien la sala\n"
          + "2. Intentar forzar la puerta\n"
          + "3. Leer la nota\n"
          + "4. Ver la caja de herramientas medicas\n"
          + "5. Suicidarte\n"
          + "6. Mover la mesa y subirte a ella para alcanzar la rejilla:\n";
    } else {
      Texto_sala0 = "Que decides hacer?\n"
          + "1. observar bien la sala\n"
          + "2. Intentar forzar la puerta\n"
          + "3. Leer la nota\n"
          + "4. Ver la caja de herramientas medicas\n"
          + "5. Suicidarte\n";
    }

    String input = (String) JOptionPane.showInputDialog(
        null,
        Texto_sala0,
        "EscapeRoom",
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        null);

    int op = 0;
    op = Integer.parseInt(input);
    switch (op) {
      case 1:
        puntaje = puntaje + 30;
        JOptionPane.showMessageDialog(null, "+30 puntos", "Puntuacion",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
            "observas un ducto de ventilacion con una rejilla de metal tirando aire frio en la parte alta de la pared, puede ser una buena salida pero esta muy alto como para llegar",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        opTable = true;

        break;
      case 2:
        puntaje = puntaje - 50;
        JOptionPane.showMessageDialog(null, "-50 puntos", "Puntuacion",
            JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Intentas forzar la puerta pero esta muy bien asegurada y no cede",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "hiciste mucho ruido, se mas precavido pq te pueden haber escuchado",
            "Pistas",
            JOptionPane.WARNING_MESSAGE);
        break;
      case 3:
        puntaje = puntaje + 10;
        JOptionPane.showMessageDialog(null, "+10 puntos", "Puntuacion",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
            "La nota esta en ruso al parecer, pero te da mucha curiosidad asi que la guardas en tu inventario para traducirla luego",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Nota en ruso se suma a tu inventario", "Inventario",
            JOptionPane.INFORMATION_MESSAGE);
        break;
      case 4:
        puntaje = puntaje + 20;
        JOptionPane.showMessageDialog(null, "+20 puntos", "Puntuacion",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
            "Dentro de la caja de herramientas medicas encuentras un bistrui y una jeringa con una sustancia que no sabes lo que es",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Bisturi y jeringa se suma al inventario", "Inventario",
            JOptionPane.INFORMATION_MESSAGE);
        inventario.tieneBisturi = true;
        inventario.tieneJeringa = true;
        int op2 = JOptionPane.showConfirmDialog(null, "Queres clavarte la jeringa?",
            "Escaperoom", JOptionPane.YES_NO_OPTION);
        if (op2 == JOptionPane.YES_OPTION) {

          JOptionPane.showMessageDialog(null,
              "te duermes y nunca mas vuelve a despertar (era la misma sutancia somnolienta que el secuestrador habia usado contra ti , le dio tiempo a los cientificos de experimentar contigo)",
              "EscapeRoom",
              JOptionPane.INFORMATION_MESSAGE);

          JOptionPane.showMessageDialog(null, "Te moriste", "EscapeRoom",
              JOptionPane.INFORMATION_MESSAGE);
          System.exit(0);
        } else {
          JOptionPane.showMessageDialog(null,
              "deduces que es la misma sustancia con la que te durmieron y decides usarla como arma.", "EscapeRoom",
              JOptionPane.INFORMATION_MESSAGE);
        }
        break;

      case 5:
        JOptionPane.showMessageDialog(null, "te ahorcas a vos mismo hasta la muerte", "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Te moriste", "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
        break;

      case 6:
        JOptionPane.showMessageDialog(null, "+30 puntos", "Puntuacion",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
            "logras alcanzar la rejilla, observas que la rejilla esta atornillada con 4 tornillos en las esquinas",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        if (inventario.tieneBisturi) {
          int op3 = JOptionPane.showConfirmDialog(null, "Queres sacar los tornillos con el bisturi?",
              "Escaperoom", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
          if (op3 == JOptionPane.YES_OPTION) {
            puntaje = puntaje + 70;
            JOptionPane.showMessageDialog(null, "+70 puntos", "Puntuacion",
                JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,
                "logras sacar los tornillos con el bisturi y abrir la rejilla, entras al ducto de ventilacion y logras escapar de la habitacion",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
            salaActual = 1;

          } else {
            JOptionPane.showMessageDialog(null,
                "decides no usar el bisturi para sacar los tornillos, tal vez luego encuentres otra forma de salir, te bajas de la mesa",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } else {
          int op4 = JOptionPane.showConfirmDialog(null, "Queres intentar forzar la puerta??",
              "Escaperoom", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
          if (op4 == JOptionPane.YES_OPTION) {
            puntaje = puntaje - 50;
            JOptionPane.showMessageDialog(null, "-50 puntos", "Puntuacion",
                JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,
                "Intentas forzar la puerta pero esta muy bien asegurada y no cede, tal vez luego encuentres otra forma de salir, te bajas de la mesa",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,
                "hiciste mucho ruido, se mas precavido pq te pueden haber escuchado",
                "Pistas",
                JOptionPane.WARNING_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null,
                "decides no forzar la puerta, tal vez luego encuentres otra forma de salir, te bajas de la mesa",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
        break;

      default:
        JOptionPane.showMessageDialog(null, "Opción no válida. Intenta de nuevo.");
        // volver a llamar a la sala0 para una nueva elección

    }
    return salaActual;
  }

  public int sala1(int puntaje, int salaActual) {
    JOptionPane.showMessageDialog(null, "Gateas por unos ductos muy oscuros, apenas alcanzas a ver hacia delante",
        "EscapeRoom",
        JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "Con duda avanzas unos metros y el ducto se divide en 2 caminos",
        "EscapeRoom",
        JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null,
        "Por el camino de la izquierda sale el aire frio y se escucha ruido de maquinas ",
        "EscapeRoom",
        JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "Por el de la derecha no notas nada, solo oscuridad",
        "EscapeRoom",
        JOptionPane.INFORMATION_MESSAGE);

    String[] opciones = { "Derecha", "Izquierda" };

    int op5 = JOptionPane.showOptionDialog(
        null,
        "Que camino tomas?",
        "EscapeRoom",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[0]);
    if (op5 == 0) {
      puntaje = puntaje + 30;
      JOptionPane.showMessageDialog(null, "+30 puntos", "Puntuacion",
          JOptionPane.INFORMATION_MESSAGE);
      JOptionPane.showMessageDialog(null,
          "Luego de avanzar unos metros ves luz a lo lejos, hay una rejilla que da con otra habitación, te acercas para ver que es, es una biblioteca",
          "EscapeRoom",
          JOptionPane.INFORMATION_MESSAGE);
      salaActual = 2; // Avanza a la siguiente sala
    } else if (op5 == 1) {
      JOptionPane.showMessageDialog(null,
          "Te cortas la cabeza con un ventilador que habia en el ducto, parece que de ese ventilador provenia el aire frio y el sonido de maquinas",
          "EscapeRoom",
          JOptionPane.ERROR_MESSAGE);
      JOptionPane.showMessageDialog(null, "Te moriste de desangrado", "EscapeRoom",
          JOptionPane.ERROR_MESSAGE);
      // Aquí puedes implementar una chance de que el jugador haya sobrevivido
      System.exit(0);
    }
    return salaActual;
  }













  public void sala2() {
    JOptionPane.showMessageDialog(null, "Sala 2 - Biblioteca",
        "EscapeRoom",
        JOptionPane.INFORMATION_MESSAGE);
    String input = (String) JOptionPane.showInputDialog(
        null,
        "¿Qué deseas hacer? \n 1. romper la rejilla con el bisturí\n2. observar con detenimiento:\n ",
        "EscapeRoom",
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        null);

    switch (Integer.parseInt(input)) {
      case 1:
        JOptionPane.showMessageDialog(null,
            "Usando toda tu fuerza logras ceder una sección debilitada de la rejilla. El metal se parte con un sonido oxidado, más fuerte de lo que esperabas.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
            "Caés varios metros, golpeando mal el hombro contra una piso flotante de madera.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
            "Apenas lográs recuperar el aire cuando escuchás pasos, Calmos, No alarmados.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Como si alguien ya supiera exactamente dónde ibas a caer.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "De entre las luces frías del pasillo surge un hombre alto, delgado \n" + //
            "con una bata impecablemente blanca. No lleva armas visibles. \n" +
            "Sus ojos, tranquilos. Demasiado tranquilos.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
        JOptionPane.showMessageDialog(null, "—Hola, (pj) ",
            "???",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
        JOptionPane.showMessageDialog(null, "dice en tu idioma perfecto, apenas manchado de un acento ruso ",
            "???",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
        JOptionPane.showMessageDialog(null, "—. Soy el doctor Boris Mikhailov. No deberías estar aquí.",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris); 
        JOptionPane.showMessageDialog(null, "Extiende una mano, no en amenaza, \n" +  "sino casi como si estuviera recibiendo a un paciente.",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris); //crear imagen de boris extendiendo la mano
            
       JOptionPane.showMessageDialog(null, "—Me intriga ",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda);
         JOptionPane.showMessageDialog(null, " —agrega, observándote como si fueras un resultado experimental inesperado ",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda); 
         JOptionPane.showMessageDialog(
          null, "¿Cómo has llegado hasta aqui sin que nadie te detuviera?",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda);
         JOptionPane.showMessageDialog(null, "Su tono no es de alarma… es de curiosidad genuina.\n" + //
                      " Y eso te incomoda más que si hubiera gritado.",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda);
         JOptionPane.showMessageDialog(null, "¿Quién eres? ¿Y qué es este lugar? ¿Qué me hicieron?", // implementar opcion para poder elegir lo que decir (si da el tiempo)
            "Personaje",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Personaje);
                 JOptionPane.showMessageDialog(null, "Boris titubea apenas. Como si por un segundo \n" + 
                                      "se debatiera entre responder… \n" +
                                                  "o proteger algo mucho más grande.",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda);
                    JOptionPane.showMessageDialog(null, "—Este lugar es una cura —dice finalmente, \n pero sus ojos no acompañan sus palabras—. \n O al menos… eso es lo que ellos decidieron que debía ser. " ,
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris); 
                    JOptionPane.showMessageDialog(null, "Se acerca un paso más, habla más bajo.",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris); 
                    JOptionPane.showMessageDialog(null, "—Si has llegado hasta mí, (nombre del personaje)",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda); 
                    JOptionPane.showMessageDialog(null, "—susurra—… eso significa que algo salió mal.",
            "Boris Mikhailov",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Boris); 
         Object[] opciones = {"Tomar su mano", "Atacarlo con la jeringa", "CORRER"};
int seleccion = JOptionPane.showOptionDialog(null, "Boris cambia repentinamente su expresion y su tono \n a una sonrisa extraña, se inclina y extiende mas su mano hacia ti \n" + //
                             "— Toma mi mano —dice con un tono seguro—.\n  te ayudare a salir de aqui", "Boris", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Iconos.Boris_Mano, opciones, opciones[0]);
switch (seleccion) {
  case 0: 
      // Tomar su mano
      break;
      
  case 1:
      // Atacar con la jeringa
      break;
      
  case 2:
      // CORRER
      break;
}
        break;




      case 2:
        JOptionPane.showMessageDialog(null,
            "Te encuentras en una sala enorme —aproximadamente 30 × 30 metros—\n" +
                "colmada de estanterías repletas de libros. En la esquina derecha se alinean cuatro oficinas; \n" +
             "cada una tiene una mesa alta de madera, una silla, una lámpara de escritorio y \n" +
                 "una computadora de aspecto potente. En una de esas oficinas hay un hombre inclinado \n" +
            "sobre unos papeles, como si revisara documentos con atención. \n" +
                "",

            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE, Iconos.Biblioteca); // esta imagen hay que cambiarla, poner una q siga
                                                                 // mejor la descripcion
        JOptionPane.showMessageDialog(null,
            "Con mucha cautela rompes la rejilla y, sin hacer apenas ruido, desciendes por el conducto.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,
            "Te deslizas hasta el suelo y te escondes detrás de una estantería cercana.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,
            "La luz tenue de la habitacion apenas alcanza las cubiertas:",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,
            "la mayoría son textos de psicología —lo deducís por las portadas— y están escritos en ruso.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE); // agregar imagen de libros en ruso
                    JOptionPane.showMessageDialog(null,
            "Contra la pared, al final de las estanterías,  \n" +
                            "hay un mueble metálico con varios cajones que parecen contener archivos.  \n" + //
                                                            "En lo alto del mueble hay un cartel que dice ДОКУМЕНТЫ: ПЛАН ВОЛЬЯ.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null,
            "Justo entonces escuchás pasos: el hombre que estaba en la oficina \n" + //
                            "se dirige hacia el mueble. Tenés que decidir rápido.",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
           String op5 = (String) JOptionPane.showInputDialog(
        null,
        "¿Qué hacés? \n 1. Esconderte y atacarlo por detrás cuando revise los archivos \n 2. Correr \n 3. Atacarlo frontalmente con el bisturí ",
        "EscapeRoom",
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        null);
    switch (Integer.parseInt(op5)) {
      case 1: 
      JOptionPane.showMessageDialog(null,
              "Te metés en un hueco entre las estanterías,  \n" +
                  "aguardás hasta que abra los cajones y\n" +
                  "entonces atacás por sorpresa.",
              "EscapeRoom",
              JOptionPane.INFORMATION_MESSAGE);
    break;
      case 2:
     Random rand = new Random();
     if(rand.nextInt(100) < 30) { //30% de evadir) {
       JOptionPane.showMessageDialog(null,
            "Lográs evadirlo y corrés hacia una puerta de madera al fondo del pasillo. ",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
     } else {
       JOptionPane.showMessageDialog(null,
            "Intentás salir disparado por el pasillo. El hombre reacciona con reflejos sorprendentes: \n" + 
            "te agarra del brazo con fuerza y, con voz fría, dice: «No deberías estar aquí». \n" +  // poner imagenes maybe
            "Antes de que puedas zafar, te clava la jeringa en el brazo.\n" + 
            "La sedación te invade. Caés dormido y no volvés a despertar. ",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog(null,
            "Te moriste",
            "EscapeRoom",
            JOptionPane.INFORMATION_MESSAGE);
       System.exit(0);
     }
      break;
      case 3:
 // implementar minijuego de combate por tiempo de reaccion
   break;
    }
        break;

      default:
        JOptionPane.showMessageDialog(null, "Opción no válida. Intenta de nuevo.");
        // volver a llamar a la sala2 para una nueva elección
    }
  }










  public void sala3() {
    // implementar comportamiento de la sala 3
  }












  public void sala4() {
    // implementar comportamiento de la sala 4
  }












  public void sala5() {
    // sala adicional para evitar duplicados de nombre
  }







}

class Inventario {
  // esto despues hacer array
  boolean tieneNotaRusa = false;
  boolean tieneBisturi = false;
  boolean tieneJeringa = false;

}

public class Main {

  public static void main(String[] args) {
    Random rand = new Random();
    // Control del juego
    boolean juegoActivo = true;
    int salaActual = 0;
    int puntaje = 100;
    boolean gameFinished = false;
    // Constantes del juego
    Salas salas = new Salas();
    final int MAX_SALAS = 8;
    final String CODIGO_SECRETO = "1947";
    final String RESPUESTA_ACERTIJO = "eco";
    System.out.println("╔════════════════════════════════════════════╗");
    System.out.println("║     🔒 ESCAPE ROOM: EXPERIMENTO HUMANO 🔒    ║");
    System.out.println("╚════════════════════════════════════════════╝");
    System.out.println("Texto introductorio");
    while (!gameFinished) {
      switch (salaActual) {
        case 0:
          salaActual = salas.sala0(puntaje, salaActual);
          break;
        case 1:
          salaActual = salas.sala1(puntaje, salaActual);
          // Update salaActual or gameFinished as needed
          break;
        case 2:
          salas.sala2();
          break;
        case 3:
          salas.sala3();
          break;
        case 4:
          salas.sala4();
          break;
        case 5:
          salas.sala5();
          break;
        case 6:
        case 7:
        case 8:
          // Implement additional salas if needed
          gameFinished = true; // End game for now
          break;
      }

    }
  }

}