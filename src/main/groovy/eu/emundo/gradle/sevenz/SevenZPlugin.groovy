package eu.emundo.gradle.sevenz

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtraPropertiesExtension

class SevenZPlugin implements Plugin<Project> {

    @Override
    void apply(final Project project) {
        ExtraPropertiesExtension extraProperties =
                project.getExtensions().getExtraProperties();
        extraProperties.set(UnSevenZ.class.getSimpleName(), UnSevenZ.class);
    }

}
