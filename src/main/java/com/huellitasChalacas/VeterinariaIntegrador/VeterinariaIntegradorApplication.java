package com.huellitasChalacas.VeterinariaIntegrador;

import com.huellitasChalacas.VeterinariaIntegrador.scheduleTasks.DatabaseBackupTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeterinariaIntegradorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinariaIntegradorApplication.class, args);
    }

//    @Autowired
//    private DatabaseBackupTask databaseBackupTask;
//
//    @Override
//    public void run(String... args) throws Exception {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        databaseBackupTask.realizarBackup();
//    }
}
