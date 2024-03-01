import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

// I'm not using this yet - just wanted a basic ascii art card printer setup.
/* TODO: Most things, including documentation
   Its printing a little skewed due to the Java Console != Terminal .... flush issue?
*/
public class GraphicPokerCard {
    private List<String> values = Arrays.asList(new String[]{
            "  ___  \n / _ \\ \n| | | |\n| |_| |\n \\___/ \n       \n",
            "    _    \n   / \\   \n  / _ \\  \n / ___ \\ \n/_/   \\_\\\n         \n",
            " ____  \n|___ \\ \n  __) |\n / __/ \n|_____|\n       \n",
            " _____ \n|___ / \n  |_ \\ \n ___) |\n|____/ \n       \n",
            " _  _   \n| || |  \n| || |_ \n|__   _|\n   |_|  \n        \n",
            " ____  \n| ___| \n|___ \\ \n ___) |\n|____/ \n       \n",
            "  __   \n / /_  \n| '_ \\ \n| (_) |\n \\___/ \n       \n",
            " _____ \n|___  |\n   / / \n  / /  \n /_/   \n       \n",
            "  ___  \n ( _ ) \n / _ \\ \n| (_) |\n \\___/ \n       \n",
            "  ___  \n / _ \\ \n| (_) |\n \\__, |\n   /_/ \n       \n",
            " _   ___\n/ | / _ \\ \n| | || ||\n| | ||_||\n|_| \\___/\n",
            "     _ \n    | |\n _  | |\n| |_| |\n \\___/ \n       \n",
            "  ___  \n / _ \\ \n| | | |\n| |_| |\n \\__\\_\\\n       \n",
            " _  __\n| |/ /\n| ' / \n| . \\ \n|_|\\_\\\n      \n"
    });

    private Hashtable<String, String> faces = new Hashtable<>();
    protected String curFace = "h";
    protected int curValue = 1;

    public GraphicPokerCard() {
        setupTable();
    }

    public GraphicPokerCard(String curFace, int curValue) {
        this.curFace = curFace;
        this.curValue = curValue;
        setupTable();
    }

    private void setupTable() {
        faces.put("h", "\t ,-.-.\n\t `. ,'\n\t   `");
        faces.put("d", "\\t _________\\n\\t/_|_____|_\\\\ \\n\\t'. \\   / .'\\n\\t  '.\\\\ /.'\\n\\t    '.'");
        faces.put("c", "\\t   _\\n\\t  (_)\\n\\t (_)_)\\n\\t   T");
        faces.put("s", "\\t   . \\n\\t  /.\\\\ \\n\\t (_._)\\n\\t   |");
    }

    public String newCard(String newFace, int newValue) {
        curValue = newValue;
        curFace = newFace;
        return get_card();
    }

    public String get_card() {
        return String.join("\n", new String[] {
                values.get(curValue), faces.get(curFace),
                String.join("\t\t\t\n\t\t",
                        values.get(curValue).split("\n"))
        });
    }

}
