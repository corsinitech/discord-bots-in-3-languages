/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class App {
    public static final String TOKEN = tokenreader();

    public static void main(String[] args) {        
        DiscordApi api = new DiscordApiBuilder().setToken(TOKEN).login().join();

        api.addMessageCreateListener(new PingCommand());
        api.addMessageCreateListener(new UserRoleListCommand());

    }

    public static String tokenreader(){

        String line = "";
        File file = new File("/mnt/d/Code/javacord/gradle-demo/app/src/main/java/demo/token.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((line = reader.readLine()) != null) {
               return line; 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
