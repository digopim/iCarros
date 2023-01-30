package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {

    //Q1 - Fizzing 'n Buzzing

        //return int 1-100
        // if multiple of 3 - prints "Fizz"
        // if 5 or mul of prints "Buzz"
        // if mul off 3 and 5 print "FizzBuzz"
    public static void fizzBuzz(){
        int FIZZ_DIV = 3;
        int BUZZ_DIV = 5;
        String FIZZ = "Fizz";
        String BUZZ = "Buzz";
        StringBuilder sb;
        for (int i = 1; i<= 100; i++){
            sb = new StringBuilder();
            if(i % FIZZ_DIV == 0){sb.append(FIZZ);};
            if(i % BUZZ_DIV == 0){sb.append(BUZZ);}
            if(sb.length() == 0){sb.append(i);}
            System.out.println(sb.toString());
        }
    }

    // Q2 - Angry Marvin Birds ---- revisar
        // 0 to 3 starts
        // param = String[] result (ex: "___" or "*__")
        // "_" not star "*" equals star
        // return total number of stars have

    public static long angryBirds(String[] stages){
        return Stream.of(stages).reduce("", (stars, s) -> stars + s).chars().filter(value -> value == '*').count();
    }

    //Q3 - Creepy hours
        // Parttern time = HH:MM
        // beep if AB:AB or AA:BB AB:BA or AA:AA
        // param String[] moments
        // return count of beeps
    public static int creepyHours(String[] moments){
        int count = 0;
        String EMPTY = "" ;
        String SEPARATOR = ":" ;

        for (String time :moments){
            LinkedList<String> numbers = new LinkedList<String>(Arrays.asList(time.replace(SEPARATOR, EMPTY).split(EMPTY)));
            String first = numbers.remove(0);
            if(!first.isEmpty() && numbers.removeFirstOccurrence(first) && numbers.stream().count() == 2 && numbers.stream().distinct().count() == 1){
                count++;
            }
        }
        return count;
    }

    //Q4 - We are the champions, my friend
        // winner +3 loser +0 tie +1
        // param int[] wins , int[] ties
        // i equal a team
        // 3 + 2 i = 0
        // 0 + 2 i = 1
        // 9 + 0 i = 2
        // return sum of points from the winner team

    public static String championPoints(int[] wins, int[] ties){
        int WIN_MULTIPLIER = 3;
        int TIE_MULTIPLIER = 1;
        List<Integer> totalPoints =  Arrays.stream(wins).map(w -> w * WIN_MULTIPLIER).boxed().collect(Collectors.toList());

        for (int i = 0; i < ties.length; i++) {
            int tiePoints = ties[i] * TIE_MULTIPLIER;
            try {
                int points = totalPoints.get(i) + tiePoints;
                totalPoints.set(i, points);
            } catch (IndexOutOfBoundsException e){
                totalPoints.add(tiePoints);
            }
        }

        int winnerPoints = totalPoints.stream().max(Integer::compareTo).get();
        int winnerTeam = totalPoints.indexOf(winnerPoints);

        return winnerPoints + " (the team at i=" + winnerTeam + " would win this championship)";
    }

    //Q5 -
        //    SELECT o.OrderID as OrderID , sum(ct.Price) as TotalPrice
        //    from Orders o
        //    left join Customer cr ON o.CustomerID = cr.CustomerID
        //    left join Component ct ON ct.OrderID = o.OrderID
        //    where cr.CustomerName = 'DeathStar'
        //    group by o.OrderID


    //Q6 - MarsRover
        // more then one robot
        // map = rectangular
        // Position = (x,y, cardinalLeatter) ex: N,S,L,W - x = row y = collumn
        // commands = L(90º Left), R(90º Right) and M(move 1 grid point)
        // Start point = (N,N)
        // two lines of input = position, instructions[]
        // position = (int int String)
        // return curent Position;
        // Primeira linha são os limites do retangulo
        // cada robo recebe 2 linhas, primeira linha é a posição dele e a segunda linha são os movimentos q ele tem q fazer
        // os robos se movem sequencialmente, não podem funcionar ao mesmo tempo,
        // a saida é a posição final de cada robo
    public static String rover(String commands){
        String EMPTY = "" ;
        String SEPARATOR = " " ;
        String NEW_LINE = "\\r?\\n";
        StringBuilder sb = new StringBuilder();
        int limitX = 0;
        int limitY = 0;

        List<String> lines = new ArrayList<String>(Arrays.asList(commands.split(NEW_LINE)));
        String[] firstLine = lines.remove(0).split(SEPARATOR);
        limitX = new Integer(firstLine[0]);
        limitY = new Integer(firstLine[1]);

        for (int i = 0; i < lines.size(); i++){
            String[] line = lines.get(i).split(SEPARATOR);
            Robot bot = new Robot(limitX, limitY, new Position(new Integer(line[0]), new Integer(line[1]), line[2]));
            sb.append(bot.start(lines.get(++i))).append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        fizzBuzz();
        System.out.println(angryBirds(new String[]{"---", "*--", "**-", "***"}));
        System.out.println(creepyHours(new String[]{"11:00", "13:13", "10:00"}));
        System.out.println(creepyHours(new String[]{"01:01", "11:22", "10:01", "22:22", "11:23", "", "01:0", "12:3", "1", "12", ":"}));
        System.out.println(championPoints(new int[]{1,0,3}, new int[]{2,2,0}));

        StringBuilder sb = new StringBuilder();
        sb.append("5 5").append(System.getProperty("line.separator"))
                .append("1 2 N").append(System.getProperty("line.separator"))
                .append("LMLMLMLMM").append(System.getProperty("line.separator"))
                .append("3 3 E").append(System.getProperty("line.separator"))
                .append("MMRMMRMRRM").append(System.getProperty("line.separator"))
        ;

        System.out.println(rover(sb.toString()));

    }

}