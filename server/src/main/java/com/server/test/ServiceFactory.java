package com.server.test;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceFactory {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path relative = Paths.get("");
        String path = relative.toAbsolutePath().toString().replaceAll("\\\\","/");
//        System.out.print(path+"/server/src/main/java/com/server/test/jars/database.jar");
//        File dbservice = new File("//jars//database.jar");
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", path+"/server/src/main/java/com/server/test/jars/database.jar");
        ProcessBuilder diceprocess = new ProcessBuilder("java", "-jar", path+"/server/src/main/java/com/server/test/jars/dice.jar");
        ProcessBuilder gateway = new ProcessBuilder("java", "-jar", path+"/server/src/main/java/com/server/test/jars/gateway.jar");
        Process p = pb.start();
        Process d = diceprocess.start();
        Process g = gateway.start();
    }
}
