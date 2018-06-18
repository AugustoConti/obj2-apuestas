# TP Integrador - Obj2 UNQ 2018 - 1er Semestre

## Casa de Apuestas Deportivas Online

### Introducción
Un casa de apuestas deportivas online permite a usuarios realizar distintos tipos de apuestas relacionadas a eventos deportivos. La casa de apuestas trabaja con los siguientes deportes: fútbol, tenis, basquetball, voley y boxeo.

## Partido/Juego
Un partido o juego es una competencia deportiva en el que se enfrentan dos oponentes y tiene un resultado final. El deporte en cuestión determina qué tipos de oponentes se enfrentan y cuáles son los posibles resultados. Los deportes en conjunto enfrentan a equipos (compuesto por deportistas), mientras que los deportes individuales enfrentan a deportistas individuales. Asimismo, mientras en todos los deportes puede existir un ganador y un perdedor, sólo algunos deportes pueden arrojar un empate como resultado. Por ejemplo, el tenis es un deporte individual en el que un juego siempre finaliza con un deportista ganador y otro perdedor. Mientras que el fútbol es un deporte en equipo que admite el empate como resultado final.

Partido:
- Deporte
- Oponentes
- Fecha y hora de comienzo
- Lugar donde se desarrolla la competición
- Resultado parcial o final (siempre que la competición haya comenzado)

Deportistas:
 - Nombre
 - Apellido
 - Fecha 
 - Lugar de nacimiento. 

Equipo:
- Deportistas
- Nombre

## Cuotas de apuestas
Al momento de crear un evento deportivo, se debe calcular la cuota o, dicho de otro modo, cuánto “pagará” cada posible resultado. La cuota de un posible resultado es un reflejo de la probabilidad de que se dé tal resultado.

En el caso de un pronóstico acertado, la cuota servirá para determinar la ganancia obtenida a partir de dicho acierto. Por ejemplo, si la cuota de un posible resultado es de 2.00, significa que la casa de apuestas pagará 2.00 pesos por cada peso apostado en caso de acierto. Entonces, si se apuestan 10 pesos de forma acertada, la ganancia bruta del apostador ascenderá a 20 y la neta, a 10.

La gran cantidad de eventos que se disputan diariamente dificultan la estimación “manual” de la probabilidad de cada resultado posible. Por eso, las casas de apuestas utilizan distintos algoritmos para decidir las mismas. A continuación se detallan los mismos:

- Competencia histórica directa: se decide utilizando el historial de enfrentamientos directos entre los oponentes. Por ejemplo, si el historial entre dos equipos de fútbol consta de 20 partidos, de los cuales el equipo A ha ganado 14, el B 4 y el resto fueron empates, entonces la probabilidad de que el equipo A resulte victorioso es 0.7, que lo sea el equipo B es 0.2 y el empate 0.1.
- Historia reciente: se toman los 10 partidos más recientes de cada oponente y se toma la proporción de resultados para determinar la probabilidad. Por ejemplo si un equipo ha ganado 3 de sus últimos 10 partidos, la probabilidad de ganar el próximo será de 0.3. La probabildad de un empate, en este caso, se calcula como el promedio entre la probabilidad de empate de cada oponente.

Una vez calculada la probabilidad de cada posible resultado, se decide la cuota con la siguiente cuenta: Cuota de victoria oponente X = 1 + (1 - probabilidad de victoria del oponente X). Por ejemplo, si la probabilidad de que triunfe el equipo A es 0.7, la cuota del equipo A será 1,3.

> Usted debe considerar que en cualquier momento la casa de apuestas puede cambiar el algoritmo utilizado y que, además, deben poder agregarse nuevos algoritmos en cualquier momento.

## Apuesta
Un usuario que ingresa al sitio puede realizar sus apuestas. Luego de buscar el partido en el cual quiere apostar, selecciona su apuesta y decide el monto que apostará en el mismo. De una apuesta se debe poder conocer la ganacia bruta y la ganancia neta (explicadas con anterioridad). Sin embargo, no es posible determinar la ganancia de una apuesta cuyo partido aún no ha finalizado. 

> Existen dos tipos de apuestas: apuesta final y apuesta segura.

### Apuesta final
La apuesta final es una apuesta que no puede cancelarse en ningún momento.

### Apuesta segura
La apuesta segura permite al usuario cancelar la misma. La contrapartida de este tipo de apuesta es que, en caso de acierto, al usuario se le descontará el 15% de la ganancia obtenida para dicha apuesta.

En cuanto a la cancelación, existen algunas condiciones que dependen del momento en que se quiere realizar la misma:

- Si el partido aún no ha comenzado, entonces la apuesta se puede cancelar y se le cobra al usuario una penalidad fija de $200. Si el usuario se arrepiente de haber cancelado la apuesta, y el partido aún no ha comenzado, puede reactivarla.
- Si el partido está en juego, entonces la apuesta se puede cancelar y se le cobra al usuario una penalidad del 30% del total que haya apostado. Con el partido en juego la apuesta no puede ser reactivada.
- Si el partido ha finalizado, no es posible cancelar la apuesta.

## Envío mensual de balance

El último día de cada mes el sitio de apuestas online le debe enviar a cada usuario el balance (ganancia) del mes. El envío del balance se realiza vía mensaje de texto. Para ello, asuma que existe la siguiente definición:

```java
public interface BalanceNotifier{
	void notifyBalance(User user, Integer month, BigDecimal monthlyBalance);
}

public class TextMessageBalanceNotifier implements BalanceNotifier{
	@Override
	void notifyBalance(User user, Integer month, BigDecimal monthlyBalance)
	{
		//codigo
	}
}
```

> Nota: usted no debe implementar la clase TextMessageBalanceNotifier. Simplemente asuma que exista.

# Hito 2

## Envío mensual de balance vía Email
La casa de apuestas puede optar por enviar el balance mensual a los usuarios por email, en lugar de hacerlo por mensaje de texto.

Para ello, ya existe una clase con la siguiente definición (asuma que esta clase existe y que NO puede ser modificada):

```java
public class EmailBalanceNotifier {
     void emailBalance(String userEmail, Integer month, BigDecimal monthlyBalance){
           //codigo
     }
}
```

> Se debe permitir que la casa de apuestas notifique el balance por email, de la misma manera que lo hace por mensaje de texto.

## Sistema de Notificaciones
Debe ser posible que diversos interesados puedan suscribirse y recibir notificaciones ante cambios en los partidos. En particular, son eventos de interés el comienzo y la finalización de un partido.  

En primer lugar, los usuarios deben ser notificados cuando un partido en el que realizó una apuesta ha comenzado o finalizado. Esto le permitirá dar un seguimiento a sus apuestas.

Asimismo la casa de apuestas debe ser notificada cada vez que un partido comienza, ya que de esa manera dejará de ofrecer el partido para apuestas. Usted no debe implementar nada respecto a la oferta de partidos para apuestas que posee la casa de apuestas. Sólo asegúrese que la casa de apuestas reciba la notificación correspondiente.

> Tenga en cuenta que pueden haber nuevos interesados en ser notificados de estos eventos.

## Búsqueda de Eventos Deportivos
Ante la gran cantidad de eventos deportivos disponibles, la casa de apuestas debe proveer mecanismos para realizar búsquedas complejas. Los siguientes son criterios por los cuales se pueden realizar búsquedas:

- Fecha del partido
- Deporte
- Lugar del partido
- Oponente que interviene en el partido

Estos criterios pueden ser combinados de diversas formas con operadores lógicos OR y AND, para formar expresiones complejas. Los siguientes son ejemplos de criterios de búsqueda:

- Fecha del partido > ‘20/04/2019’
- Deporte = ‘Futbol’ AND  Oponente = ‘Estudiantes de La Plata’
- Deporte = ‘Futbol’ AND (Oponente  = ‘Estudiantes’ OR Oponente = ‘Aldosivi’)
- (Lugar = 'La Plata' AND Oponente  = ‘Estudiantes’ AND Oponente = ‘Gimnasia’) OR (Lugar = 'CABA' AND Oponente  = ‘Boca’ AND Oponente = ‘River’)

# Cronograma y Pautas de Entrega

## Cronograma:

Se establecen tres instancias de visado, en las cuales deberán estar presentes todos los miembros del grupo para defender el trabajo:

|Visado      |Fecha          |
|------------|---------------|
|Hito 1		 |`Viernes 01/06`|
|Hito 2		 |`Viernes 22/06`|
|Hito 2 Final|`Viernes 06/07`|

## Entrega del Hito 1

- Modelo de Clases: realizar el modelo de clases para el dominio descripto y confeccionar el Diagrama de Clases en UML correspondiente. Debe entregar un único archivo en formato PDF. No se aceptarán entregas en otros formato.

- Codificación en Java: debe tener codificado en Java al menos la funcionalidad correspondiente a las secciones Partido/Juego y Cuotas de Apuestas. Debe incluir tests, con al menos un 95% de cobertura utilizando la herramienta de eclipse EclEmma.

## Entrega del Hito 2:

- Modelo de Clases: realizar el modelo de clases para el dominio descripto y confeccionar el Diagrama de Clases en UML correspondiente. Debe entregar un único archivo en formato PDF. No se aceptarán entregas en otros formato.

- Codificación en Java: debe tener codificado en Java la totalidad de la funcionalidad correspondientes a los Hitos 1 y 2.
