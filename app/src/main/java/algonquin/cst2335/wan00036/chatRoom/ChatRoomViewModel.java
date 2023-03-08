package algonquin.cst2335.wan00036.chatRoom;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import algonquin.cst2335.wan00036.chatRoom.Data.ChatMessage;

public class ChatRoomViewModel  extends ViewModel {
    public MutableLiveData<ArrayList<ChatMessage>> messages = new MutableLiveData< >();
}
