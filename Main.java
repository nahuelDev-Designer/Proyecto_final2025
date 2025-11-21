import javax.swing.ImageIcon;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Timer;
import javax.swing.Icon;

class Iconos {
    public static final ImageIcon Personaje = new ImageIcon(Iconos.class.getResource("/imagenes/pj.png"));
    public static final ImageIcon Boris = new ImageIcon(Iconos.class.getResource("/imagenes/Boris.png"));
    public static final ImageIcon Mikhail = new ImageIcon(Iconos.class.getResource("/imagenes/Mikhail.png"));
    public static final ImageIcon Alexei = new ImageIcon(Iconos.class.getResource("/imagenes/Alexei.png"));
    public static final ImageIcon Biblioteca = new ImageIcon(Iconos.class.getResource("/imagenes/Biblioteca.png"));
    public static final ImageIcon Boris_duda = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_duda.png"));
    public static final ImageIcon Boris_Mano = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_Mano.png"));
    public static final ImageIcon Boris_herido = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_herido.png"));
    public static final ImageIcon Boris_death = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_death.png"));
    public static final ImageIcon Boris_atacado = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_atacado.png"));
    public static final ImageIcon Fondo = new ImageIcon(Iconos.class.getResource("/imagenes/fondo.png"));
    public static final ImageIcon Boris_fight = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_fight.png"));
    public static final ImageIcon Boris_esquivando = new ImageIcon(Iconos.class.getResource("/imagenes/Boris_esquivando.png"));
        public static final ImageIcon sala4 = new ImageIcon(Iconos.class.getResource("/imagenes/sala4.png"));
         public static final ImageIcon logo = new ImageIcon(Iconos.class.getResource("/imagenes/logo.png"));
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
                JOptionPane.showMessageDialog(null,
                        "hiciste mucho ruido, se mas precavido pq te pueden haber escuchado",
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
                inventario.tieneNotaRusa = true;
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
                            "deduces que es la misma sustancia con la que te durmieron y decides usarla como arma.",
                            "EscapeRoom",
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

    public int sala2(int puntaje, int salaActual) {
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
                JOptionPane.showMessageDialog(null,
                        "De entre las luces frías del pasillo surge un hombre alto, delgado \n" + //
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
                JOptionPane.showMessageDialog(null,
                        "Extiende una mano, no en amenaza, \n"
                                + "sino casi como si estuviera recibiendo a un paciente.",
                        "Boris Mikhailov",
                        JOptionPane.INFORMATION_MESSAGE, Iconos.Boris); // crear imagen de boris extendiendo la mano

                JOptionPane.showMessageDialog(null, "—Me intriga ",
                        "Boris Mikhailov",
                        JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda);
                JOptionPane.showMessageDialog(null,
                        " —agrega, observándote como si fueras un resultado experimental inesperado ",
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
                JOptionPane.showMessageDialog(null, "¿Quién eres? ¿Y qué es este lugar? ¿Qué me hicieron?", // implementar
                                                                                                            // opcion
                                                                                                            // para
                                                                                                            // poder
                                                                                                            // elegir lo
                                                                                                            // que
                                                                                                            // decir (si
                                                                                                            // da el
                                                                                                            // tiempo)
                        "Personaje",
                        JOptionPane.INFORMATION_MESSAGE, Iconos.Personaje);
                JOptionPane.showMessageDialog(null, "Boris titubea apenas. Como si por un segundo \n" +
                        "se debatiera entre responder… \n" +
                        "o proteger algo mucho más grande.",
                        "Boris Mikhailov",
                        JOptionPane.INFORMATION_MESSAGE, Iconos.Boris_duda);
                JOptionPane.showMessageDialog(null,
                        "—Este lugar es una cura —dice finalmente, \n pero sus ojos no acompañan sus palabras—. \n O al menos… eso es lo que ellos decidieron que debía ser. ",
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
                Object[] opciones = { "Tomar su mano", "Atacarlo con la jeringa", "CORRER" };
                int seleccion = JOptionPane.showOptionDialog(null,
                        "Boris cambia repentinamente su expresion y su tono \n a una sonrisa extraña, se inclina y extiende mas su mano hacia ti \n"
                                + //
                                "— Toma mi mano —dice con un tono seguro—.\n  te ayudare a salir de aqui",
                        "EscapeRoom", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Iconos.Boris_Mano,
                        opciones,
                        opciones[0]);

                switch (seleccion) {
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "Parece que te esta ayudando a levantarte pero con su otra mano saca \n" +
                                        "una jeringa de su bolsillo tracero y te la clava rapidamente",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null,
                                "La expresion de Boris cambia a una sonrisa maligna y burlona, cierras los ojos y nunca vuelves a despertar.",
                                "Boris Mikhailov",
                                JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
                        System.exit(0);
                        break;

                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Mientras estas torpemente mueviendo tu mano intentando encontrar donde esta la jeringa, \n con una precision y rapidez que da miedo Boris te clavo la jeringa en la arteria del cuello.",
                                "Boris Mikhailov",
                                JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
                        JOptionPane.showMessageDialog(null, "Cierras los ojos y nunca vuelves a despertar.",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null,
                                "te impulsas con las 2 manos y corres entre las estanterias de la sala a toda velocidad buscando con desesperacion una salida",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null,
                                "Boris entre risas te sigue caminando con unos pasos firmes y seguros.",
                                "Boris Mikhailov",
                                JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
                        JOptionPane.showMessageDialog(null,
                                "Boris-No hay escapatoria para ti- dice con un tono oscuro.",
                                "Boris Mikhailov",
                                JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
                        JOptionPane.showMessageDialog(null,
                                "Por un milagro encuentras una puerta de madera que logras forzar con el bisturi",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);

                        sala3(puntaje, salaActual);
                        break;
                }
                break;

            case 2:
                JOptionPane.showMessageDialog(null,
                        "Te encuentras en una sala enorme —aproximadamente 30 × 30 metros—\n" +
                                "colmada de estanterías repletas de libros. En la esquina derecha se alinean cuatro oficinas; \n"
                                +
                                "cada una tiene una mesa alta de madera, una silla, una lámpara de escritorio y \n" +
                                "una computadora de aspecto potente. En una de esas oficinas hay un hombre inclinado \n"
                                +
                                "sobre unos papeles, como si revisara documentos con atención. \n" +
                                "",

                        "EscapeRoom",
                        JOptionPane.INFORMATION_MESSAGE, Iconos.Biblioteca); // esta imagen hay que cambiarla, poner una
                                                                             // q siga
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
                        Object[] armas = { "Bisturí", "Jeringa" };
                        int eleccionArma = JOptionPane.showOptionDialog(
                                null,
                                "¿Con qué atacás?",
                                "EscapeRoom",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                Iconos.Boris_duda,
                                armas,
                                armas[0]);

                        if (eleccionArma == 0) {
                            puntaje = puntaje + 50;
                            JOptionPane.showMessageDialog(null, "+50 puntos", "Puntuacion",
                                    JOptionPane.INFORMATION_MESSAGE);
                            JOptionPane.showMessageDialog(null,
                                    "Le clavas el bisturí en la nuca. El hombre \n cae sin emitir apenas un sonido.",
                                    "Ataque", JOptionPane.INFORMATION_MESSAGE);
                            JOptionPane.showMessageDialog(
                null,
                "Luego de matar al científico decides seguir investigando",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "encuentras una puerta gris y decides intentar abrirla pero no puedes",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
                            return 6;
                        } else if (eleccionArma == 1) {

                            if (inventario.tieneJeringa) {
                                puntaje = puntaje + 10;
                                JOptionPane.showMessageDialog(null, "+10 puntos", "Puntuacion",
                                        JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Le aplicás la jeringa en la nuca y lo dormís",
                                        "Ataque con jeringa", JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Perdes la jeringa del inventario", "Inventario",
                                        JOptionPane.INFORMATION_MESSAGE);
                                inventario.tieneJeringa = false;
                                JOptionPane.showMessageDialog(
                null,
                "Luego de matar al científico decides seguir investigando",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "encuentras una puerta gris y decides intentar abrirla pero no puedes",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
                                return 6;

                            } else {
                                JOptionPane.showMessageDialog(null, "No tenés jeringa en el inventario.", "Inventario",
                                        JOptionPane.WARNING_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR_OPCION_INVALIDA", "Ataque",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        Random rand = new Random();
                        if (rand.nextInt(100) < 30) { // 30% de evadir) {
                            JOptionPane.showMessageDialog(null,
                                    "Lográs evadirlo y corrés hacia una puerta de madera al fondo del pasillo. ",
                                    "EscapeRoom",
                                    JOptionPane.INFORMATION_MESSAGE);
                            JOptionPane.showMessageDialog(null,
                                    "???-No hay escapatoria para ti- dice con un tono oscuro.",
                                    "???",
                                    JOptionPane.INFORMATION_MESSAGE, Iconos.Boris);
                            JOptionPane.showMessageDialog(null,
                                    "Por un milagro encuentras una puerta de madera que logras forzar con el bisturi",
                                    "EscapeRoom",
                                    JOptionPane.INFORMATION_MESSAGE);

                                sala3(puntaje, salaActual);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Intentás salir disparado por el pasillo. El hombre reacciona con reflejos sorprendentes: \n"
                                            +
                                            "te agarra del brazo con fuerza y, con voz fría, dice: «No deberías estar aquí». \n"
                                            + // poner
                                              // imagenes
                                              // maybe
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
                        JOptionPane.showMessageDialog(
                                null,
                                "Prepárate para atacar por sorpresa...",
                                "Minijuego de reacción",
                                JOptionPane.INFORMATION_MESSAGE,
                                Iconos.Fondo);

                        long startTime = System.currentTimeMillis();
                        JOptionPane.showMessageDialog(
                                null,
                                "¡ATACA AHORA! (haz click lo más rápido posible)",
                                "Minijuego de reacción",
                                JOptionPane.INFORMATION_MESSAGE,
                                Iconos.Boris_fight // Cambia el icono si quieres otra imagen
                        );
                        long reaction = System.currentTimeMillis() - startTime;

                        if (reaction < 1000) { // Menos de 1 segundo
                            JOptionPane.showMessageDialog(
                                    null,
                                    "¡Ataque exitoso! Logras sorprenderlo.",
                                    "Minijuego de reacción",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    Iconos.Boris_atacado);
                            JOptionPane.showMessageDialog(
                                    null,
                                    "El enemigo es abatido.",
                                    "Minijuego de reacción",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    Iconos.Boris_death);

                            JOptionPane.showMessageDialog(
                null,
                "Luego de matar al científico decides seguir investigando",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                "encuentras una puerta gris y decides intentar abrirla pero no puedes",
                "EscapeRoom",
                JOptionPane.INFORMATION_MESSAGE);
                            return 6;
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "¡Fallaste! El enemigo reacciona a tiempo y te esquiva.",
                                    "Minijuego de reacción",
                                    JOptionPane.ERROR_MESSAGE,
                                    Iconos.Boris_esquivando);
                            JOptionPane.showMessageDialog(
                                    null,
                                    "El enemigo te contraataca clavandote una jeringa en el cuello.",
                                    "Minijuego de reacción",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    Iconos.Boris

                            );
                            JOptionPane.showMessageDialog(null,
                                    "te duermes y nunca mas vuelve a despertar",
                                    "EscapeRoom",
                                    JOptionPane.INFORMATION_MESSAGE);

                            JOptionPane.showMessageDialog(null, "Te moriste", "EscapeRoom",
                                    JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                        break;
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Intenta de nuevo.");
                // volver a llamar a la sala2 para una nueva elección
        }
        return salaActual;
    }

    public int sala21(int puntaje, int salaActual) {
      salaActual = 6;
        String input = (String) JOptionPane.showInputDialog(
                null,
                "Que decides hacer?\n"
                        + "1. Ver el cuerpo del cientifico a ver si tenia algun objeto util\n"
                        + "2. Intentar abrir la puerta gris\n"
                        + "3. Usar las computadoras\n"
                        + "4. Revisar los archivos\n",
                "EscapeRoom",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        switch (Integer.parseInt(input)) {
            case 1:
                JOptionPane.showMessageDialog(null,
                        "Encuentras una jeringa en su bolsillo trasero, una tarjeta de identificacion con su nombre y foto, \n  y una nota que dice acetijo clave de la computadora: Hablo sin boca, y oigo sin oídos. Aunque no soy nadie, a menudo respondo. ¿Qué soy? ",
                        "EscapeRoom",
                        JOptionPane.INFORMATION_MESSAGE);
                if (!inventario.tieneJeringa) {
                    JOptionPane.showMessageDialog(null, "Jeringa se suma al inventario", "Inventario",
                            JOptionPane.INFORMATION_MESSAGE);
                    inventario.tieneJeringa = true;
                }
                break;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "Intentas abrir la puerta pero esta cerrada con un codigo numerico",
                        "EscapeRoom",
                        JOptionPane.INFORMATION_MESSAGE);

    String codigo = (String) JOptionPane.showInputDialog(null,
                        "Introduce el codigo de la puerta (en caso de no saber tirar al azar pero no le des a cancel):",
                        "EscapeRoom",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null);
    if(codigo.equals("1947")){
     salaActual = 4;
     sala4(puntaje);
    } else {
                        JOptionPane.showMessageDialog(null,
                        "Fallaste, pero notas que la puerta tiene una nota pegada en ruso, posiblemente sea el codigo de la puerta, pero deberias traducirla primero",
                        "EscapeRoom",
                        JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Nota de la puerta se suma a tu inventario", "Inventario",
                        JOptionPane.INFORMATION_MESSAGE);
                inventario.notadelapuerta = true;
    }


                break;
            case 3:
                JOptionPane.showMessageDialog(null,
                        "Te acercas a las computadoras y ves que estan bloqueadas con un codigo de letras",
                        "EscapeRoom",
                        JOptionPane.INFORMATION_MESSAGE);
                String respuesta = (String) JOptionPane.showInputDialog(null,
                        "Introduce la contraseña para desbloquear la computadora (en caso de no saber tirar al azar pero no le des a cancel):",
                        "EscapeRoom",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null);
                if (respuesta.equalsIgnoreCase("eco")) {
                    JOptionPane.showMessageDialog(null,
                            "Lograste abrir la computadora, aunque esta en ruso puedes manejarla viendo los iconos, ahora puedes \n traducir los documentos o las notas que encuentres",
                            "EscapeRoom",
                            JOptionPane.INFORMATION_MESSAGE);
                    if(inventario.tieneNotaRusa){
                        JOptionPane.showMessageDialog(null,
                                "Usando la computadora logras traducir la nota en ruso que encontraste en la sala donde despertaste:\n\n" +
                                "DOCUMENTO Nº17 — PROYECTO «VOLYA»\n\n" +
                                "Sujeto de prueba: [17]\n" +
                                "Estado: activo\n\n" +
                                "Objetivo del experimento: observar los límites de la voluntad humana.\n" +
                                "El sujeto será sometido a los siguientes procedimientos:\n\n" +
                                "1. Modulación química de los centros del miedo y la obediencia.\n" +
                                "2. Implantación de estímulos conductuales mediante impulsos neuronales.\n" +
                                "3. Aislamiento sensorial y reeducación de la respuesta al dolor.\n" +
                                "4. Borrado cognitivo y restauración de recuerdos falsos.\n" +
                                "5. Fase final: prueba de autoconciencia bajo control externo.\n\n" +
                                "Todos los datos deben ser registrados.\n" +
                                "En caso de muerte del sujeto, conservar la actividad cerebral durante 3 minutos.\n" +
                                "No intervenir sin orden directa del doctor Volkov.",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                    if(inventario.notadelapuerta){
                        JOptionPane.showMessageDialog(null,
                                "Usando la computadora logras traducir la nota de la puerta y descubres que el codigo \n es el año en el que se fundo la organizacion, quizas lo diga en algun documento",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                   if(!inventario.notadelapuerta && !inventario.tieneNotaRusa && !inventario.tieneDocumentos) {
                        JOptionPane.showMessageDialog(null,
                                "No tienes nada que traducir en el inventario",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                if(inventario.tieneDocumentos){
                                            JOptionPane.showMessageDialog(null,
                                "Usando la computadora logras traducir los documentos que agarraste de los archivos del cientifico",
                                "EscapeRoom",
                                JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,
                        "DOCUMENTO Nº01 — PROYECTO «VOLYA»\n" +
"Fecha de creación: 12 de febrero de 1947\n" +
"Clasificación: SECRETO / ACCESO RESTRINGIDO\n" +
"\n" +
"Acta interna redactada por el grupo promotor —veteranos de guerra y personal científico—\n" +
"quienes han definido la necesidad de un intervencionismo sistemático sobre la naturaleza\n" +
"de la voluntad humana. Las observaciones recogidas durante el conflicto mostraron una\n" +
"persistente propensión de los individuos al egoísmo destructivo cuando el control social\n" +
"se debilita. De estas constataciones surge la conclusión de que la libertad de la voluntad\n" +
"facilita la repetición de abusos masivos y violencia. Nuestra función es reexaminar el valor\n" +
"de la libertad y formular un medio de corrección.\n" +
"\n" +
"El objetivo del proyecto es desarrollar métodos científicamente fundados para bloquear\n" +
"los impulsos que conducen a la resistencia consciente y al comportamiento antisocial,\n" +
"sin destruir la vida biológica del sujeto. Pretendemos diseñar un sistema que combine\n" +
"intervenciones médico-químicas, técnicas electrofisiológicas y reprogramación psicológica\n" +
"dirigida para transformar de manera fiable la esfera motivacional.\n" +
"\n" +
"Las motivaciones de la iniciativa no son la venganza ni la sed de poder por sí misma, sino\n" +
"el temor a la repetición de consecuencias catastróficas provocadas por la libre voluntad.\n" +
"Creemos que la disciplina sustentada en control científico protegerá a las futuras generaciones\n" +
"del desorden de las acciones colectivas.\n" +
"\n" +
"Los métodos propuestos a estudio comprenden enfoques combinados: uso selectivo de compuestos\n" +
"psicoactivos para disminuir la reactividad del centro emocional, estimulación eléctrica puntual\n" +
"de áreas corticales implicadas en la toma de decisiones y reentrenamiento por condicionamiento\n" +
"reflejo mediante estimulación controlada y desensibilización. Simultáneamente investigamos la\n" +
"implantación de una red de señales correlacionadas que permita predecir y neutralizar los\n" +
"brotes de insubordinación en fase temprana.\n" +
"\n" +
"Las cuestiones éticas y legales se tratan como variables controlables por los protocolos del\n" +
"proyecto; todo el trabajo se realiza en régimen cerrado y con estrictas medidas de secreto.\n" +
"Se espera obtener un conjunto reproducible, regulable y escalable de medidas, aplicable tanto\n" +
"a individuos aislados como, en una fase ulterior, a colectivos si la situación lo requiere.\n" +
"\n" +
"Firmado: Dr. Dmitri Volkov\n" +
"Director científico del Proyecto «VOLYA»\n");
                }
                break;
                case 4:
                JOptionPane.showMessageDialog(null,
                        "Revisas los archivos y encuentras varios documentos en ruso sobre experimentos con humanos y sobre la fundacion, \n uno de ellos llama tu atencion y decides traducirlo usando la computadora",
                        "EscapeRoom",
                        JOptionPane.INFORMATION_MESSAGE);
                inventario.tieneDocumentos = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                // volver a llamar a la sala2 para una nueva elección
                break;

        }
        return salaActual;
    }

    public int sala3(int puntaje, int salaActual) {
      Inventario inventario = new Inventario();
      inventario.tieneBisturi = true;
      Iconos Iconos = new Iconos();
         
          int Intentos = 4;
                              int Operator3;
                              String DialogInput3;
                              String narrative21 = "Te acercas a la puerta y observas que es una puerta de metal blindada.\n"
                                        +"asi mismo, ves un teclado y pantalla que requiere un pin de 4 digitos a su lado, "
                                      + "hay una placa que tiene una inscripción en ruso: «ПЛАН ВОЛЬЯ — ВХОД»"+
                                        "Ademas de que pareciera que la puerta esta atornillada con una tapa\n";
                                       
                              JOptionPane.showMessageDialog(null,narrative21, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                              while (Intentos!=0) {
                                 
                              String narrative22 = "Acciones:\n"
                                        +"1. Introducir el código"
                                      + "2. Forzar la tapa atornillada";
                                        
                                       
                         DialogInput3 = JOptionPane.showInputDialog(null,narrative22, "EscapeRoom", JOptionPane.QUESTION_MESSAGE); 
                              Operator3 = Integer.parseInt(DialogInput3); 
                                  
                                  
                              switch (Operator3) {
                                  case 1: 
                                      int Save0;
                                      int codigo = 3633;
                                      String DialogInput4;
                                      String narrative23 = "Introduzca el codigo:";
                                       DialogInput4 = JOptionPane.showInputDialog(null,narrative23, "EscapeRoom", JOptionPane.QUESTION_MESSAGE);
                                     Save0 =  Integer.parseInt(DialogInput4);
                                     
                                       if (Save0==codigo) {
                                       String DialogInput900 = "Codigo correcto\n"+
                                               "Logras pasar a la siguiente sala...";
                                       JOptionPane.showMessageDialog(null, DialogInput900, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                       Intentos = -1;
                                       break;
                                       }
                                       
                                       else if (Save0!=codigo) {
                                          
                                           if (Intentos==4) {
                                               String narrative24 = "Haz fallado en el codigo, la maquina emitio un sonido de error.\n"+
                                                       "Te quedan 3 intentos restantes";
                                                JOptionPane.showMessageDialog(null,narrative24, "EscapeRoom", JOptionPane.ERROR_MESSAGE); 
                                                Intentos = Intentos - 1;
                                             
                                                break;
                                                
                                               
                                                
                                           }else if (Intentos==3) {
                                               String narrative25 = "Haz fallado en el codigo, la maquina emitio un pitido y encendio \n"+
                                                       "una luz roja. Tu rostro fue resgistrado por una camara.\n"
                                                       +"Te queda 2 intento";
                                                JOptionPane.showMessageDialog(null,narrative25, "EscapeRoom", JOptionPane.ERROR_MESSAGE); 
                                                Intentos = Intentos - 1;
                                                break;
                                           
                                           }else if (Intentos==2) {
                                             String narrative25 = "Haz fallado en el codigo, la maquina activo una medida de seguridad \n"+
                                                       "emitiendo un fuerte pitido, que te molesta, por lo que piedes habiliades motoras finas.\n"
                                                       +"Te queda 1 intento";
                                                JOptionPane.showMessageDialog(null,narrative25, "EscapeRoom", JOptionPane.ERROR_MESSAGE); 
                                                Intentos = Intentos - 1; 
                                                break;
                                           }else if (Intentos<2) {
                                               String narrative26 = 
                                                       "Haz fallado en el codigo, la maquina\n"+
                                               "empieza a emitir un ruido fuerte y la sala destaca por el color rojo\n"
                                                       +"Los guardias encuentran tu ubicacion y te disparan causando tu muerte";
                                                JOptionPane.showMessageDialog(null,narrative26, "EscapeRoom", JOptionPane.ERROR_MESSAGE); 
                                                Intentos = Intentos - 1;  
                                                System.exit(0);
                                                break;
                                           }
                                       }
                                       break;


                                  case 2:
                                
                                      if (Intentos>2 && inventario.tieneBisturi == true) {
                                          
                                            String narrative1001 = "Logras hacer palanca con el bisturi, y apretar un boton.\n"
                                                    +"Por lo que logras pasar a la siguiente sala (El Sotano)";
                                         JOptionPane.showMessageDialog(null, narrative1001, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                         Intentos = 0;
                                         break;  
                                          }
                                          
                                          
                                          
                                          
                                      
                                      else if (Intentos<=2 || inventario.tieneBisturi == false) {
                                          String narrative1000 = "No tienes suficiente Psicomotrizidad o herramientas para hacer esto";
                                    
                                          JOptionPane.showMessageDialog(null, narrative1000, "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                                         break;
                                      }
                              }  
                              }
         
         
         
         
         
         
        JOptionPane.showMessageDialog(null, "Sala 3 - Laboratorio",
                "EscapeRoom",JOptionPane.INFORMATION_MESSAGE);
                String narrative0 = "Cierras la puerta y gracias a que la forzaste,el mecanismo de la cerradura se rompe y no puedes volver a abrirla,\n"
                + "sin mas opción, decides avanzar por unas escaleras en plena oscuridad,"
                 + "las cuales cada vez te llevan mas abajo.";
                 String narrative1 = "Al bajar del todo, lo único que puedes ver son muebles y al lado tuyo un botón rojo,\n"
                 + "como tu visión no es clara no puedes ver que son esos muebles.";
                 JOptionPane.showMessageDialog(null, narrative0, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                         JOptionPane.showMessageDialog(null, narrative1, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                         String[] Opciones0 = {"apretar boton", "No apretar boton"};
             int Opcion0 =  JOptionPane.showOptionDialog(null, "EscapeRoom", "¿Que deseas hacer con el boton?",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,Opciones0, 0);
         System.out.println(Opcion0);
         
         if (Opcion0==1) {
             String narrative2 = "No apretaste el boton, por lo que al no ver nada,\n"
                     +"decides acercarte un poco mas, mientras caminas te tropiezas \n" 
                     +"con una botella cayendo al piso. Tu cabeza quedo expuesta contra\n"
                     +"el filo de la escalera, lo que causa que te desnuques.";
             JOptionPane.showMessageDialog(null, narrative2, "EscapeRoom", JOptionPane.ERROR_MESSAGE);
             System.exit(0);
         }else {
                     String narrative3 = "Escuchas el ruido de un generador. Al apretar el boton activaste la luz, ahora puedes\n"
                             + "ver con claridad, a lo que muy alejeado de ser simples muebles,descubrís una amplia sala de experimentación médica. \n"
                             +"Las luces fluorescentes parpadean débilmente sobre camillas metálicas y grandes monitores cerebrales. \n"
                             +"En la mesa de trabajo hay jeringas, máscaras filtrantes, piezas anatómicas en miniatura (costillas, cráneos),\n"
                             +"un pastillero semanal y cuadernos con apuntes científicos. El ambiente es frío y silencioso; sólo se oye el \n"+
                             "lejano de máquinas. De pronto, las voces de los científicos se filtran por los altavoces:";
                       JOptionPane.showMessageDialog(null, narrative3, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                       JOptionPane.showMessageDialog(null, "Alexei (voz fría): «La mente humana es un músculo: sin dolor no hay aprendizaje».", "EscapeRoom", JOptionPane.PLAIN_MESSAGE, Iconos.Alexei);
                       JOptionPane.showMessageDialog(null, "Mikhail (entonación burlona): «Cada rincón de este lugar está diseñado para engañarte… ¿Realmente crees que puedes escapar de tu propia psique?».", "EscapeRoom", JOptionPane.PLAIN_MESSAGE, Iconos.Mikhail);
                       
                       String narrative4 = "La tensión invade el aire. En el fondo se perciben celdas con sujetos conectados a máquinas de \n"
                           +"electroencefalograma. A un lado, una consola central parpadea con datos médicos. Frente a vos "+
                               "hay una mesa repleta de instrumentos de laboratorio y notas de investigación. Tenés varias opciones...";
                       JOptionPane.showMessageDialog(null,narrative4, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE,null);
                        String narrative5 = "Opciones:\n"+ "1. **Explorar las celdas experimentales.** Caminar hacia las celdas donde duermen pacientes conectados a equipo neurológico. \n"+
                                "2. **Revisar la consola de control.** Analizar los monitores y bases de datos médicos del laboratorio.\n"
                                + "3. **Investigar la mesa de trabajo.** Examinar los instrumentos, frascos de reactivos y apuntes científicos sobre la mesa.";
                                
                       String Operator0 = JOptionPane.showInputDialog(null, narrative5, "EscapeRoom", JOptionPane.QUESTION_MESSAGE);
                      switch (Integer.parseInt(Operator0)) {
                          case 1:
                              salaActual = 4;
                               sala4(puntaje);
                               
                               
                          case 2:
                               int Operator1;
                               String DialogInput0;
                              String narrative7 = "te acercás al panel de ordenadores junto a un banco de trabajo tecnológico.\n"+
                                      " El monitor muestra datos de los sujetos conectados: porcentaje de actividad cerebral, historial de medicación y gráficos ominosos de ondas mentales.\n"+
                                      " En otra pantalla ves planos del edificio y contraseñas parciales. Una pequeña terminal segura protege comandos críticos.\n"+
                                      "Mientras examinás los menús, escuchás la voz de Alexei a través de los altavoces: «Cualquier acción que tomes ya fue prevista».";
                              JOptionPane.showMessageDialog(null, narrative7, "EscapeRoom",JOptionPane.INFORMATION_MESSAGE);
                                  
                                   
                              String narrative6 = "1. Consultar los registros médicos en la base de datos.\n"+
                                      "2. Activar el botón de apagado de emergencia (corte de energía).";
                           
                                  DialogInput0 = JOptionPane.showInputDialog(null, narrative6, "EscapeRoom",JOptionPane.QUESTION_MESSAGE);
                                  
                                Operator1 = Integer.parseInt(DialogInput0);
                                 if(Operator1==1) {
                                     String narrative8 = "Navegás por los archivos digitales y descubrís expedientes confidenciales. En una carpeta llamada ”Informe PETROV” aparecen fotos tuyas como “próxima evaluación”.\n"+
                                      "Encuentras análisis de los experimentos: tu cerebro debía ser sometido a una ilusión definitiva. También hallás un video donde Mikhail explica “el tratamiento del subconsciente”.\n"+
                                      " Además, bajo contraseña ves el número 8642, indicado como código de acceso principal a la puerta de salida.\n";
                                            
                                     
                                     JOptionPane.showMessageDialog(null,narrative8, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                     
                                     String narrative9 = "- *Reacción inmediata:* Al ingresar ese código en la consola, las luces se vuelven verdes y se\n"
                                             +"oyen clics lejanos: las cerraduras se desbloquearon. Sentís una ola de alivio momentáneo.";
                                     JOptionPane.showMessageDialog(null,narrative9, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                     
                                     String narrative10 = "Derrota inevitable: Creyendo escapar, salís corriendo hacia una escalera lateral. Pero a mitad \n"
                                             +"del pasillo las luces centellean y Mikhail aparece al fondo con una mascarilla de gas: «La \n"
                                             +"realidad es maleable… y la tuya termina aquí». Un gas soporífero te atrapa. Caés de rodillas.\n "
                                             +"Cuando despertás, podés ver el logo de un programa de lavado de memoria parpadeando en un monitor.\n"
                                             +"La derrota se gatilla aquí: los científicos ganan; tu mente es reprogramada sin dejar rastro de tu identidad.";
                                             JOptionPane.showMessageDialog(null,narrative10, "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                                             System.exit(0);
                                         
                                     
                                     
                                 }else if (Operator1==2) {
                                     String narrative11 = "Oprimís el interruptor rojo de emergencia. Las luces se apagan inmediatamente y se \n"
                                             +"activa una alarma estridente. Se escucha el zumbido de generadores cediendo. De pronto, en la \n"
                                             +"penumbra ves una figura que se acerca: es Alexei con su bisturí encendido.\n "
                                             +"El laboratorio queda a oscuras. Alexei se mueve entre las sombras hasta atraparte con una inyección hipnótica en el cuello.\n";
                                               JOptionPane.showMessageDialog(null,narrative11, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                               String narrative12 = " Antes de perder el conocimiento, oís su voz cercana: «Apagar el equipo\n"
                                             +"no sirve si el control está en nosotros». Caés inconsciente. Al recobrar los sentidos, \n"
                                             +"descubrís que estás sujeto a una mesa de experimentos, sometido a un escáner cerebral. La \n "+
                                              "derrota se gatilla aquí: sin electricidad ni ayuda, los científicos concluyen el experimento eliminando tu personalidad.";
                                                JOptionPane.showMessageDialog(null,narrative12, "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                                                System.exit(0);
                                     break;
                                  
                                 }
                                 
                                 
                                 
                                 
                                 
                                 break;
                          case 3: 
                            int Operator2;
                            String DialogInput1;
                              String narrative13 = "examinás los objetos dispersos: pipetas con líquidos fluorescentes, un microscopio\n"+
                                      " portátil, bisturíes y varios frascos marcados con etiquetas crípticas. También encontrás un cuaderno\n"
                                             +"de notas con diagramas neuronales y ecuaciones de neuroplasticidad\n"+
                                         " En una esquina ves un destornillador y un frasco de líquido amarillento. Te concentrás y aparecen dos posibles acciones:";
                              JOptionPane.showMessageDialog(null,narrative13, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                              
                              String narrative14 = "1. Mezclar el reactivo desconocido (el líquido) en uno de los equipos cercanos.\n"
                              + "2. Revisar detalladamente la libreta de apuntes científicos.";
                       DialogInput1 = JOptionPane.showInputDialog(null, narrative14, "EscapeRoom",JOptionPane.QUESTION_MESSAGE);
                        Operator2 = Integer.parseInt(DialogInput1);
                           if (Operator2==1) {
                                String narrative15 = "Tomás el frasco con precaución y vertés parte del líquido en el conducto de\n"+
                                      "ventilación de un aparato experimental. En seguida escuchás un siseo químico. Las máquinas\n"
                                             +"comienzan a crepitar y chisporrotear. Se desata un chorro de ácido que corroe cables y tubos,\n"+
                                         "generando un pequeño incendio.";
               
                                         JOptionPane.showMessageDialog(null,narrative15, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                String narrative16 = "Reacción inmediata: Una alarma ensordecedora indica fuga química. Alexei irrumpe con un \n"
                                        +"extintor de fuego: «¡Inútil sacrificio!». La cámara de seguridad capta tu rostro asustado.";
                                JOptionPane.showMessageDialog(null,narrative16, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                String narrative17 = "Derrota inevitable: Antes de extinguir por completo el incendio, tu visibilidad se nubla por\n"
                                        +"el humo tóxico. Caés al suelo tosiendo. En la oscuridad veis a Alexei acercarse con un"+
                                        "bisturí entre las manos. La derrota se gatilla aquí: con tu mundo reducido a caos y fuego, \n"
                                        +"tu cuerpo sucumbe al humo y los científicos cierran el experimento.";
                                
                                JOptionPane.showMessageDialog(null,narrative15, "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                                System.exit(0);
                           
                           }else if (Operator2==2) {
                              String narrative18 = "Abres la libreta y lees con tensión: son apuntes de Mikhail sobre inducir\n"
                                        +"alucinaciones y manipulación de la realidad. Hay una nota en la última página: “Cuando el"+
                                        "paciente crea que escapa, habremos ganado.” Comprendés que todo esto es parte de su \n"
                                        +"experimento mental. Instantes después, la habitación se oscurece y las paredes parecen\n"
                                      +"cerrarse. Oís risas lejanas…";
                              JOptionPane.showMessageDialog(null,narrative18, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                              
                              String narrative19 = "Reacción inmediata: Las luces fallan y oís la voz susurrante de Mikhail: «La victoria siempre \n"
                                        +"fue nuestra».";
                                        
                              JOptionPane.showMessageDialog(null,narrative19, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                              
                               String narrative20 = "Derrota inevitable: La realidad se distorsiona a tu alrededor: te mareás y sentís que caés. Al \n"
                                        +"despertar, te encontrás atado boca abajo en la camilla principal. La derrota se gatilla aquí: \n"
                                       +"estás atrapado dentro de la ilusión que ellos crearon, vencido por tus propios sentidos \n"
                                       +"y listo para el siguiente experimento.";
                                        
                              JOptionPane.showMessageDialog(null,narrative20, "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                              System.exit(0);
                              
                             
                              
                          }         
                          break;     
                              
                          
                     
                     }
         
         }


      
        return salaActual;
    }


public void sala4(int puntaje) {
     Inventario inventario = new Inventario();
    String descripcion = "Antes de entrar pasás por un pasillo; al fondo hay una puerta de metal.\n"
            + "Mirás por la cerradura: una sala circular (~20 m de diámetro), luces frías,\n"
            + "una enorme máquina neuronal en el centro con pulsos rojos. Cables y tubos azules\n"
            + "extienden por el suelo. En las paredes, pantallas muestran ondas cerebrales y datos.\n"
            + "Ves 3 científicos: uno prepara sustancias químicas, otro en una computadora conectada\n"
            + "a la máquina central y otro en una consola con brazos mecánicos. Hay lectores junto a las puertas\n"
            + "(todas abren con tarjeta). En una mesa hay un mapa que muestra: Despacho del Líder (noreste),\n"
            + "Cámara Secreta (suroeste) y Salida de Servicio (norte).";
    JOptionPane.showMessageDialog(null, descripcion, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE, Iconos.sala4);

    String[] opciones = {"Robar tarjeta (computadora)", "Atacarlos", "Cortar/romper cable", "Esconderte y observar", "Huir", "Rendirse"};
    int elec = JOptionPane.showOptionDialog(null, "¿Qué decis hacer?", "EscapeRoom",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

    if (elec == -1 || elec == 5) {
        JOptionPane.showMessageDialog(null, "Te rendiste. Fin de la partida.", "Rendición", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    switch (elec) {
        case 0:
            JOptionPane.showMessageDialog(null,
                    "Te acercás gateando y ponés la mano en su bolsillo...\n" +
                            "El científico se da vuelta, saca un arma y te dispara.",
                    "EscapeRoom", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            break;
        case 1:
            JOptionPane.showMessageDialog(null,
                    "Sacás el bisturí e intentás atacar al que está en la computadora...\n" +
                            "El científico tenía un arma y te mata.",
                    "EscapeRoom", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            break;
        case 2:
            JOptionPane.showMessageDialog(null,
                    "Cortás un grueso cable que va a la máquina central. Las luces se apagan, la sala queda en completa oscuridad.\n" +
                            "Los científicos gritan y empiezan a inspeccionar las máquinas; ahora hay oportunidad.",
                    "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);

            String[] opcionesPostSabotaje = {"Atacar sigilosamente al que arregla las máquinas", "Atacar al de la computadora", "Esconderte", "Rendirse"};
            int e2 = JOptionPane.showOptionDialog(null, "¿Qué hacés ahora?", "EscapeRoom",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesPostSabotaje, opcionesPostSabotaje[0]);

            if (e2 == -1 || e2 == 3) {
                JOptionPane.showMessageDialog(null, "Te rendiste. Fin de la partida.", "Rendición", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            if (e2 == 0) {
                JOptionPane.showMessageDialog(null,
                        "Te acercás por la espalda, inmovilizás al técnico y en su bolsillo encontrás un estuche con herramientas y una tarjeta maestra.",
                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                inventario.tieneTarjeta = true;
                puntaje += 40;
                JOptionPane.showMessageDialog(null, "+40 puntos\nPuntaje actual: " + puntaje, "Puntuacion", JOptionPane.INFORMATION_MESSAGE);

                String[] afterKey = {"Huir por la Salida de Servicio", "Ir al Despacho del Jefe (noreste)", "Ir a la Cámara Secreta (suroeste)", "Rendirse"};
                int post = JOptionPane.showOptionDialog(null, "¿Qué hacés ahora?", "EscapeRoom",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, afterKey, afterKey[0]);

                if (post == -1 || post == 3) {
                    JOptionPane.showMessageDialog(null, "Te rendiste. Fin de la partida.", "Rendición", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                if (post == 0) {
                    puntaje += 20;
                    JOptionPane.showMessageDialog(null, "Corres por toda la habitacion y observas que hay una puerta negra y otra azul que requiere\n"
                    +"Una tarjeta, la puerta negra dice <The Leader>, justo en un instante, escuchas pasos detras tuyo..."+
                    "Es el!, sin embargo ya cansado del ambiente teniendo la opcion de enfrentarlo, decides ir por la puerta azul\n"
                           + "Usás la tarjeta en la puerta azul y escapás por la Salida de Servicio.\n" +
                                    "Saliste del complejo con mapa y tarjeta.\nPuntaje final: " + puntaje,
                            "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                            if(puntaje == 400) {
                                JOptionPane.showMessageDialog(null,
                                        "¡FELICITACIONES! Has alcanzado el puntaje máximo de 400 puntos. haz sacado el final perfecto",
                                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog(null,
                                        "sacaste el final estandar",
                                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                                }
                    System.exit(0);
                } else if (post == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Subís al despacho noreste. Al entrar, se activa un sistema que libera una bruma sedante.\n" +
                                    "Perdés la consciencia; quedás capturado. FINAL MALO.",
                            "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else if (post == 2) {
                    JOptionPane.showMessageDialog(null,
                            "Abrís la Cámara suroeste con la tarjeta. Los sistemas detectan actividad anómala y se liberan gases somníferos.\n" +
                                    "Perdés la consciencia dentro de la Cámara. FINAL MALO.",
                            "EscapeRoom", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    System.exit(0);
                }
            } else if (e2 == 1) {
                JOptionPane.showMessageDialog(null,
                        "Lográs neutralizar al que está en la computadora y encontrás su tarjeta personal. La consola queda parcialmente operativa.",
                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                inventario.tieneTarjeta = true;
                puntaje += 40;
                JOptionPane.showMessageDialog(null, "+40 puntos\nPuntaje actual: " + puntaje, "Puntuacion", JOptionPane.INFORMATION_MESSAGE);

                String[] opcionesTrasLeonid = {"Huir por la Salida de Servicio", "Subir al Despacho y robar dispositivo (FINAL SECRETO)", "Ir a la Cámara", "Rendirse"};
                int choix = JOptionPane.showOptionDialog(null, "¿Qué hacés ahora?", "EscapeRoom",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTrasLeonid, opcionesTrasLeonid[0]);

                if (choix == -1 || choix == 3) {
                    JOptionPane.showMessageDialog(null, "Te rendiste. Fin de la partida.", "Rendición", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                if (choix == 0) {
                    JOptionPane.showMessageDialog(null, "Salís por la Salida de Servicio con la tarjeta.\nFINAL ESTÁNDAR.\nPuntaje final: " + puntaje,
                            "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else if (choix == 1) {
                    puntaje += 90;
                    JOptionPane.showMessageDialog(null,
                            "Subís al despacho y, gracias al margen que dejaste en la consola, conseguís robar un dispositivo de control mental.\n" +
                                    "FINAL SECRETO — escapás con el dispositivo del líder.\nPuntaje final: " + puntaje,
                            "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else if (choix == 2) {
                    JOptionPane.showMessageDialog(null,
                            "Vas a la Cámara sin el vial reactivador: los prisioneros permanecen dormidos. FINAL INTERMEDIO.\nPuntaje final: " + puntaje,
                            "EscapeRoom", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                } else {
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Te ocultás entre las tuberías mientras los científicos inspeccionan; tras un rato vuelven a sus tareas y aprovechás para retirarte por la Salida de Servicio.\nPuntaje final: " + puntaje,
                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            break;
        case 3:
            JOptionPane.showMessageDialog(null,
                    "Te ocultás entre las tuberías. Viktor, que trabaja con los tanques, se acerca en voz baja.\n" +
                            "\"Te vi por las cámaras. No estoy de acuerdo con esto. Si querés ayudar...\"",
                    "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);

            inventario.tieneTarjeta = true;
            inventario.tieneVialViktor = true;
            inventario.codigoCamara = "4721";

            JOptionPane.showMessageDialog(null,
                    "Viktor te entrega su tarjeta personal (funciona en los lectores), el código de la Cámara y un vial reactivador.",
                    "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);

            String[] viktorOpc = {"Salvar a los prisioneros (FINAL HEROICO)", "No hacer caso y huir (FINAL ESTÁNDAR)", "Rendirse"};
            int oV = JOptionPane.showOptionDialog(null, "¿Qué hacés ahora?", "EscapeRoom",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, viktorOpc, viktorOpc[0]);

            if (oV == -1 || oV == 2) {
                JOptionPane.showMessageDialog(null, "Te rendiste. Fin de la partida.", "Rendición", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            if (oV == 0) {
                puntaje += 100;
                JOptionPane.showMessageDialog(null,
                        "Entrás a la Cámara con la tarjeta, ingresás el código '" + inventario.codigoCamara + "' y aplicás el vial en la consola.\n" +
                                "Los prisioneros abren los ojos, se incorporan y, aunque débiles, logran escapar por una salida lateral.\n" +
                                "FINAL HEROICO — liberaste a los prisioneros.\nPuntaje final: " + puntaje,
                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                puntaje += 20;
                JOptionPane.showMessageDialog(null,
                        "Decidís que es demasiado arriesgado y huís por la Salida de Servicio. FINAL ESTÁNDAR.\nPuntaje final: " + puntaje,
                        "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            break;
        case 4:
            JOptionPane.showMessageDialog(null,
                    "Ignorás la sala y te vas por el pasillo. FINAL ESTÁNDAR.\nPuntaje final: " + puntaje,
                    "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            break;
        default:
            System.exit(0);
            break;
    }
}



    

}

class Inventario {
    // esto despues hacer array
    boolean tieneNotaRusa = false;
    boolean tieneBisturi = false;
    boolean tieneJeringa = false;
    boolean notadelapuerta = false;
    boolean tieneDocumentos = false;
    boolean tieneTarjeta = false;
    boolean tieneVialViktor = false;
        String codigoCamara = ""; 

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
        final String CODIGO_SECRETO = "1947";
        final String RESPUESTA_ACERTIJO = "eco";
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     🔒 ESCAPE ROOM: EXPERIMENTO HUMANO 🔒    ║");
        System.out.println("╚════════════════════════════════════════════╝");

    JOptionPane.showMessageDialog(null, "", "EscapeRoom", JOptionPane.INFORMATION_MESSAGE, Iconos.logo);
       String descripcion = "Me encontraba caminando en la calle un Viernes a las 10pm de la noche. Tenia que volver a mi casa luego de las horas de apoyo en mi instituto. \n"
            + "De repente escuche pasos, no es la primera vez que me pasaba, tal vez era alguien en mi misma situacion o simplemente mi imaginación, no?…. \n"
            + "Esa noche, antes de perder la memoria y despertar en otro lugar, solo recuerdo sentir un pinchazo en el brazo como de una jeringa y dormirme\n"
            + "Desperte con una luz cegadora, en una habitacion revestida con azulejos blancos y celestes, estaba acostado sobre una cama de metal.\n\n"
            + "A mi lado habia una bomba de infusion, que deberia suministrarme una sustancia pero al parecer no funcionaba o estaba apagada\n"
            + "Al costado de la habtiacion habia una puerta blindada y a su lado una mesa de madera que arriba tenia un papel y una caja de herramientas medicas\n"
            + "Note en mi brazo el dolor de donde me habia inyectado con la jeringa ese sujeto, al parecer me la habia inyectado mal porque me salia sangre,\n"
            + "Tambien note que mi ropa habia sido cambiada por una ropa hospitalaria.";
    JOptionPane.showMessageDialog(null, descripcion, "EscapeRoom", JOptionPane.INFORMATION_MESSAGE);
        while (!gameFinished) {
            switch (salaActual) {
                case 0:
                    salaActual = salas.sala0(puntaje, salaActual);
                    break;
                case 1:
                    salaActual = salas.sala1(puntaje, salaActual);
                    break;
                case 2:
                    salaActual = salas.sala2(puntaje, salaActual);
                    break;
                case 3:
                    salas.sala3(puntaje, salaActual);
                    break;
                case 4:
                    salas.sala4(puntaje);
                    break;
        
                case 6:
                    salaActual = salas.sala21(puntaje, salaActual);
                    break;
                case 7:
                case 8:
                    // Implement additional salas if needed
                    gameFinished = true; // End game for now
                    break;
            }

        }
    }
}
