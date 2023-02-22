package algonquin.cst2335.wan00036.chatRoom;

/*
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import algonquin.cst2335.wan00036.databinding.ActivityChatRoomBinding;

public class ChatRoom extends AppCompatActivity {
    ActivityChatRoomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.theRecycleView.setAdapter(new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
                return null;
            }
           */
/* public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }*//*


            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });




    }
    class MyRowHolder extends RecyclerView.ViewHolder{

        public TextView messageText;
        public TextView timeText;
        public MyRowHolder(@NonNull View itemView) { //itemView will the the root of the layout, ConstraintLayout
            super(itemView);
            messageText = itemView.findViewById(R.id.message);
            timeText = itemView.findViewById(R.id.time);
        }
    }
    }
*/

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import algonquin.cst2335.wan00036.R;
import algonquin.cst2335.wan00036.chatRoom.Data.ChatMessage;
import algonquin.cst2335.wan00036.chatRoom.Data.ChatViewModel;
import algonquin.cst2335.wan00036.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.wan00036.databinding.ReceiveMessagesBinding;
import algonquin.cst2335.wan00036.databinding.SentMessagesBinding;

public class ChatRoom extends AppCompatActivity {

    private RecyclerView.Adapter myAdapter;
    private ArrayList<ChatMessage> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChatRoomBinding binding=ActivityChatRoomBinding.inflate(getLayoutInflater());

        ChatViewModel chatModel = new ViewModelProvider(this).get(ChatViewModel.class);

        messages= chatModel.messages.getValue();

        if (messages==null){
            chatModel.messages.postValue(messages=new  ArrayList<ChatMessage>());
        }

        /*loads buttons / text on screen */
        setContentView(binding.getRoot());

        binding.theRecycleView.setAdapter(myAdapter=new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                if(messages.get(messages.size()-1).isSentButton()){
                    //always inflates Sent_message.xml
                    SentMessagesBinding sentMessageBinding = SentMessagesBinding.inflate(getLayoutInflater(),
                            parent, false);

                    View root = sentMessageBinding.getRoot();
                    return new MyRowHolder(root);

                }else {

                    //always inflates receive_message.xml
                    ReceiveMessagesBinding receiveMessagesBinding=ReceiveMessagesBinding.inflate(getLayoutInflater(),
                            parent,false);
                    View root = receiveMessagesBinding.getRoot();
                    return new MyRowHolder(root);
                }

            }
            //what are the textViews set to for row POSITION?
            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {



                String strMessage = messages.get(position).getMessages();
                holder.messageText.setText(strMessage);

                holder.timeText.setText(messages.get(position).getTimeSent());


            }

            @Override
            public int getItemCount() {
                return messages.size();
            }

            //function to check what kind of ChatMessage object is at row position
            // If the isSend is true, then return 0
            // so that the onCreateViewHolder checks the viewType and inflates a send_message layout.
            // If isSend is false, then getItemViewType returns 1 and onCreateViewHolder checks
            // if the viewType is 1 and inflates a receive_message layout.


            @Override
            public int getItemViewType(int position) {
                if(messages.get(position).isSentButton()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });






        binding.theRecycleView.setLayoutManager(new LinearLayoutManager(this));

//the button was clicked, and a boolean true to specify that it was the Sent button that was clicked
//As for a String representing the time sent


        binding.sendButton.setOnClickListener(click->{


            String text=binding.editText.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
            String currentDatEndTime = sdf.format(new Date());

            messages.add(new ChatMessage(text,currentDatEndTime,true));



            //redraw the whole list
            myAdapter.notifyItemInserted(messages.size()-1);

            binding.editText.setText("");//now will be empty
            binding.theRecycleView.smoothScrollToPosition(messages.size()-1);

        });



//the button was clicked, and a boolean false to specify that it was the receive button that was clicked
//As for a String representing the time receive


        binding.sendButton.setOnClickListener(click->{


            String text=binding.editText.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
            String currentDatEndTime = sdf.format(new Date());

            messages.add(new ChatMessage(text,currentDatEndTime,false));



            //redraw the whole list
            myAdapter.notifyItemInserted(messages.size()-1);

            binding.editText.setText("");//now will be empty
            binding.theRecycleView.smoothScrollToPosition(messages.size()-1);




        });





//itemView will the the root of the layout, LinearLayout








    }


    class MyRowHolder extends RecyclerView.ViewHolder{

        public TextView messageText;
        public TextView timeText;


        public MyRowHolder(@NonNull View itemView) {

            super(itemView);
            messageText= itemView.findViewById(R.id.message);
            timeText= itemView.findViewById(R.id.time);


        }
    }

}

