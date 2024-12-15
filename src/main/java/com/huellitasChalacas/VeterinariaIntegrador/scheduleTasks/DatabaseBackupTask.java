/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.scheduleTasks;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author jtorr
 */
@Slf4j
@Component
public class DatabaseBackupTask {
    // Ruta absoluta para los backups

    private final String backupPath = "C:\\Users\\jtorr\\Documents\\dumps";

    // Nombre de la base de datos
    private final String databaseName = "db_huellitachalaca";

    // Detalles de conexión (usuario y contraseña de la BD)
    private final String dbUser = "root";
    private final String dbPassword = "root";  // Cambia por tu contraseña

    // Puerto en el que corre MySQL
    private final int dbPort = 3307;

    // El cron indica que la tarea se ejecutará diariamente a las 2:00 AM
    @Scheduled(cron = "0 0 2 * * ?")
    public void realizarBackup() {
        String backupFileName = "backup-" + System.currentTimeMillis() + ".sql";
        String command = String.format("mysqldump -u %s -p%s --port=%d %s > %s\\%s",
                dbUser, dbPassword, dbPort, databaseName, backupPath, backupFileName);
        try {
            log.info("Iniciando el backup de la base de datos '{}'", databaseName);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            log.info("Backup de la base de datos '{}' realizado exitosamente. Archivo generado: {}", databaseName, backupFileName);
        } catch (IOException | InterruptedException e) {
            log.error("Error al realizar el backup de la base de datos '{}': {}", databaseName, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
