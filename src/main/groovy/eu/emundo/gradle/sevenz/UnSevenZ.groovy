package eu.emundo.gradle.sevenz

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry
import org.apache.commons.compress.archivers.sevenz.SevenZFile
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.work.InputChanges

/**
 * Gradle Task which extracts a 7z archive.
 */
class UnSevenZ extends DefaultTask {

    @InputFile
    File sourceFile

    @OutputDirectory
    File outputDir

    @TaskAction
    void extract(InputChanges inputs) {
        new SevenZFile(sourceFile).withCloseable {sevenZFile ->
            SevenZArchiveEntry entry
            while ((entry = sevenZFile.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    continue
                }
                File curfile = new File(outputDir, entry.getName())
                File parent = curfile.getParentFile()
                if (parent != null && !parent.exists()) {
                    parent.mkdirs()
                }

                int currByte = 0
                new BufferedOutputStream(new FileOutputStream(curfile)).withStream { ostream ->
                    while( (currByte = sevenZFile.read()) != -1 ) {
                        ostream.write(currByte)
                    }
                }
            }
        }
    }

}
