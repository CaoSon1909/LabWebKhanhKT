/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonpc.listeners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ACER
 */
public class ContextListener implements ServletContextListener {

    private final String DELIMETER = "=";
    public Map<String, String> readFile(String filename) {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        Map<String,String> mapper = null;
        try{
            file = new File(filename);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            
            String line = "";
            
            while ((line = br.readLine()) != null){
                if (mapper == null){
                    mapper =  new HashMap<>();
                }
                String tmp[] = line.split(DELIMETER);
                String key = tmp[0];
                String value = tmp[1];
                mapper.put(key, value);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapper;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext contextScope = sce.getServletContext();
        String path = contextScope.getRealPath("/");
        String filename = path + "/WEB-INF/mapping.txt";
        Map<String, String> mapper = readFile(filename);
        contextScope.setAttribute("MAPPER", mapper);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
