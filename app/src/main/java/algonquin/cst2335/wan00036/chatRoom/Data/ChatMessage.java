package algonquin.cst2335.wan00036.chatRoom.Data;
public class ChatMessage {




    private String messages;
    private String timeSent;
    private boolean isSentButton;

    public ChatMessage(String messages, String timeSent, boolean isSentButton) {
        this.messages = messages;
        this.timeSent = timeSent;
        this.isSentButton = isSentButton;
    }

    public String getMessages() {
        return messages;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public boolean isSentButton() {
        return isSentButton;
    }
}
@Entity
public class ChatMessage {
    @ColumnInfc(name = "message")
    protected String message;
    @ColumnInfc(name = "TimeSent")
    protected String timeSent;|
    @ColumnInfc(name = "SendOrReceive")
    protected int sendOrReceive;
}