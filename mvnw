MAVEN_OPTS='-Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn'
mvn $MAVEN_OPTS -s .buildkite/settings.xml -f pom.xml "$@"