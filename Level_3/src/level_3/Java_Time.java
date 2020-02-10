package level_3;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Java_Time {

    public static void main(String[] args) {
//        LocalDateTime LDT = LocalDateTime.now();
//        System.out.println("1\t" + LDT);
//        ZoneId ZID1 = ZoneId.of("America/Phoenix");
//        Instant time = LDT.toInstant(ZoneOffset.UTC);
//        System.out.println("2\t" + time);
//        ZonedDateTime z = time.atZone(ZID1);
//        System.out.println("3\t" + z);
//        System.out.println("4\t" + LDT);
//        ZonedDateTime zz = LDT.atZone(ZID1);
//        System.out.println("4.\t" + zz);
//        
//        ZoneId ZID2 = ZoneId.of("America/Phoenix");
//        ZonedDateTime ZDT = ZonedDateTime.now(ZID2);
//        System.out.println("5\t" + ZDT);

        LocalDateTime LDT = LocalDateTime.now();
        System.out.println(LDT);
        ZoneId ZID = ZoneId.of("America/Phoenix");
        ZonedDateTime ZDT = LDT.atZone(ZID);
        System.out.println(ZDT);
    }

}
