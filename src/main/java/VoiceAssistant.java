import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;


public class VoiceAssistant {
    public static void main(String[] args) {
        Configuration config = new Configuration();

        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\main\\resources\\3250.dic");
        config.setLanguageModelPath("src\\main\\resources\\3250.lm");

        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);

            SpeechResult speechResult = null;

            while ((speechResult = speech.getResult()) != null) {
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Voice Command is " + voiceCommand);

                if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
                    Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");
                } else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                } else if (voiceCommand.equalsIgnoreCase("Open Paint")) {
                    Runtime.getRuntime().exec("cmd.exe /c start mspaint");
                } else if (voiceCommand.equalsIgnoreCase("Close Paint")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /im mspaint.exe /f");
                } else if (voiceCommand.equalsIgnoreCase("Open Notepad")) {
                    Runtime.getRuntime().exec("cmd.exe /c start notepad");
                } else if (voiceCommand.equalsIgnoreCase("Close Notepad")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /im notepad.exe /f");
                } else if (voiceCommand.equalsIgnoreCase("Open Calculator")) {
                    Runtime.getRuntime().exec("cmd.exe /c start calc");
                } else if (voiceCommand.equalsIgnoreCase("Close Calculator")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /im CalculatorApp.exe /f");
                } else if (voiceCommand.equalsIgnoreCase("Open Youtube")) {
                    Runtime.getRuntime().exec("cmd.exe /c start chrome --new-window www.youtube.com");
                } else if (voiceCommand.equalsIgnoreCase("Lock Window")) {
                    Runtime.getRuntime().exec("cmd.exe /c Rundll32.exe user32.dll,LockWorkStation");
                } else if (voiceCommand.equalsIgnoreCase("Open Word")) {
                    Runtime.getRuntime().exec("cmd.exe /c start WINWORD");
                } else if (voiceCommand.equalsIgnoreCase("Close Word")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /im WINWORD.exe /f");
                } else if (voiceCommand.equalsIgnoreCase("Open Excel")) {
                    Runtime.getRuntime().exec("cmd.exe /c start excel");
                } else if (voiceCommand.equalsIgnoreCase("Close Excel")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /im excel.exe /f");
                } else if (voiceCommand.equalsIgnoreCase("Open Powerpoint")) {
                    Runtime.getRuntime().exec("cmd.exe /c start POWERPNT");
                } else if (voiceCommand.equalsIgnoreCase("Close Powerpoint")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /im POWERPNT.exe /f");
                } else if (voiceCommand.equalsIgnoreCase("Open Camera")) {
                    Runtime.getRuntime().exec("cmd.exe /c start microsoft.windows.camera:");
                } else if (voiceCommand.equalsIgnoreCase("Close Camera")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /F /IM WindowsCamera.exe");
                } else if (voiceCommand.equalsIgnoreCase("Open Settings")) {
                    Runtime.getRuntime().exec("cmd.exe /c start ms-settings:");
                } else if (voiceCommand.equalsIgnoreCase("Close Settings")) {
                    Runtime.getRuntime().exec("cmd.exe /c taskkill /IM SystemSettings.exe /f");
                }





            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}