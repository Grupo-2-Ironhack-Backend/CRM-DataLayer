package dbInteraction;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Comunicación con respositorio en GitHub para clonar y actualizar la base de datos.
 */

public class GitHub {


    public static void cloneDatabase() {
        try {
            /* Method 1 for accessing repository: Environment variables (Best Practices) */
            /*
            String envUri = System.getenv("JAVA_APP_URI");
            Git.cloneRepository()
                    .setURI(envUri)
                    .setDirectory(new File(Paths.get("").toAbsolutePath().toString() + "/db"))
                    .call();
            */

            /* Method 2 for accessing repository: Configuration File (Easier) */
            String cfgUri = PropertyFileReader.getPropValues().get("JAVA_APP_URI");
            Git.cloneRepository()
                    .setURI(cfgUri)
                    .setDirectory(new File(Paths.get("").toAbsolutePath().toString() + "/db"))
                    .call();

        } catch (GitAPIException e) {
            // e.printStackTrace(); // We don't want to fail the program if the clone fails.
            System.err.println("Failed to clone the database, but still continuing.");
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("Failed to clone the database, but still continuing.");
        }
    }

    public static void push(){
        try {
            /* Method 1 for providing credentials: Environment variables (Best Practices) */
            /*
            String envUsername = System.getenv("JAVA_APP_USERNAME");
            String envAccessToken = System.getenv("JAVA_APP_PASSWORD");
            UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(envUsername, envAccessToken);
            */

            /* Method 2 for providing credentials: Configuration File (Easier) */
            String cfgUsername = PropertyFileReader.getPropValues().get("JAVA_APP_USERNAME");
            String cfgAccessToken = PropertyFileReader.getPropValues().get("JAVA_APP_PASSWORD");
            UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(cfgUsername, cfgAccessToken);

            Git git = Git.open(new File(Paths.get("").toAbsolutePath().toString() + "/db"));
            git.add().addFilepattern(".").call();
            git.commit().setMessage("Auto-update").call();
            PushCommand command = git.push().setForce(true);
            command.setCredentialsProvider(credentialsProvider);
            command.call();
        } catch (IOException | GitAPIException e ) {
            e.printStackTrace(); // We don't want to fail the program if the push fails
            System.err.println("Error pushing to remote repository, but still updating local database.");
        }
    }
}
