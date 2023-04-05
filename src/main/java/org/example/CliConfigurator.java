package org.example;

import java.util.*;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "CliConfigurator", mixinStandardHelpOptions = true, version = "CliConfigurator", description = "")
class CliConfigurator implements Callable<Integer> {

    @Parameters(index = "0", description = "The tenant domain")
    String tenant;

    @Option(names = {"-c", "--clientId"}, description = "The clientID", required = true)
    String clientId;

    @Option(names = {"-cs", "--clientSecret"}, description = "The clientSecret", required = false)
    String clientSecret;

    @Option(names = {"-cc", "--clientCert"}, description = "The pkcs12 encoded certificate path", required = false)
    String clientCert;

    @Option(names = {"-ccp", "--clientCertPass"}, description = "The password for the certificate", required = false)
    String clientCertPass;

    @Option(names = {"-v",
            "--verbose"}, description = "For diagnostics.", required = false, defaultValue = "false")
    boolean verbose;

    @Option(names = {"-s",
            "--scope"}, description = "The scope (optional). Separate by comma, when more than one.", required = false, interactive = false, defaultValue = "https://outlook.office365.com/.default")
    String scope;

    @Option(names = {"-e",
            "--email"}, description = "The E-Mail Address. Tries to access E-Mails of that Mailbox, when set.", required = false, interactive = false)
    String email;

    @Option(names = {"-ef",
            "--emailFolder"}, description = "The E-Mail Folder to access over IMAP (lists recent 10 Messages)", defaultValue = "Inbox", required = false, interactive = false)
    String imapFolder;

    public static void main(String... args) {
        int exitCode = new CommandLine(new MsExchangeOnlineModernAuthTestCli()).execute(args);
        System.out.println("\nEnd");
        System.exit(exitCode);
    }

    String logLevel() {
        return verbose ? "TRACE" : "FATAL";
    }

    @Override
    public Integer call() throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", logLevel());
        int returnCode = 0;



        return returnCode;
    }

}