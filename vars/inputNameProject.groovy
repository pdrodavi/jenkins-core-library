import br.dev.pedrodavi.jenkins.pipeline.Constants

def call() {

    inputName = input([
            message: 'Input Name Project',
            parameters: [
                    string(name: 'Name Project')
            ]
    ])

    println("Nome do projeto: ${inputName}")
    println("GIT: https://git.example.com.br/devops/${inputName}.git")
    println("Pipeline: https://jenkins.example.com.br/job/${inputName}/")

    Boolean executeStage = true

    conditionalStage("Create Repository", executeStage) {

        withCredentials([string(credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBRESTJWT')]) {
            sh "curl \\\n" +
                    "  -X POST \\\n" +
                    "  -H \"Accept: application/vnd.github+json\" \\\n" +
                    "  -H \"Authorization: Bearer ${GITHUBRESTJWT}\"\\\n" +
                    "  -H \"X-GitHub-Api-Version: 2022-11-28\" \\\n" +
                    "  ${Constants.JENKINS_GITHUB_URL_API_REPOS} \\\n" +
                    "  -d '{\"name\":\"${inputName}\",\"description\":\"This is your first repository\",\"homepage\":\"https://github.com\",\"private\":true,\"has_issues\":true,\"has_projects\":true,\"has_wiki\":true}'"
        }

    }

    Boolean executeStage2 = true

    conditionalStage("Create Pipeline", executeStage2) {

        String jobScript = "pipelineJob(\"${inputName}\") {\n" +
                "    description()\n" +
                "    keepDependencies(false)\n" +
                "    definition {\n" +
                "        cps {\n" +
                "            script(\"\"\"@Library('pipeline-library') pipelineLibrary\n" +
                "\n" +
                "pipeline {\n" +
                "\n" +
                "  agent any\n" +
                "\n" +
                "  stages {\n" +
                "\n" +
                "    stage('Initialize') {\n" +
                "      steps {\n" +
                "        cleanWs()\n" +
                "        buildJavaSpringDocker(repo: \"${inputName}\")\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "  }\n" +
                "}\"\"\")\t\t}\n" +
                "    }\n" +
                "    disabled(false)\n" +
                "    configure {\n" +
                "        it / 'properties' / 'jenkins.model.BuildDiscarderProperty' {\n" +
                "            strategy {\n" +
                "                'daysToKeep'('1')\n" +
                "                'numToKeep'('2')\n" +
                "                'artifactDaysToKeep'('-1')\n" +
                "                'artifactNumToKeep'('-1')\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n"

        jobDsl scriptText: jobScript,
                removedJobAction: 'DELETE',
                removedViewAction: 'DELETE',
                lookupStrategy: 'SEED_JOB',
                additionalClasspath: [].join('\n')

    }

}

