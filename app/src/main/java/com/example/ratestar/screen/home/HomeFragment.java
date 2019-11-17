package com.example.ratestar.screen.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.ratestar.R;
import com.example.ratestar.model.User;
import com.example.ratestar.screen.home.adapter.HomeAdapter;
import com.example.ratestar.screen.main.MainActivity;
import com.example.ratestar.util.onClickFragmentInterface;


public class HomeFragment extends Fragment implements HomeAdapter.onClickContentViewItem{

    private List<User> userList = new ArrayList<>();
    public HomeAdapter mainAdapter;
    public static onClickFragmentInterface listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        return rootView;
    }

    @SuppressLint("NewApi")
    private void initView(View a) {

        RecyclerView recyclerView = a.findViewById(R.id.content);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        userList = addProfile(userList);

        mainAdapter = new HomeAdapter(userList, getActivity());
        mainAdapter.setClickContentViewItem(this);
        recyclerView.setAdapter(mainAdapter);
    }

    private List<User> addProfile(List<User> users) {

        User.UserBuilder userBuilder = new User.UserBuilder();

        users.add(userBuilder.id(0)
                .image(R.drawable.den)
                .name("Đen Vâu")
                .info("Đây là thông tin của Đen Vâu")
                .build());
        users.add(userBuilder.id(1)
                .image(R.drawable.longhalo)
                .name("Long Halo")
                .info("Đây là thông tin của Long Halo")
                .build());
        users.add(userBuilder.id(2)
                .image(R.drawable.vu)
                .name("Vũ")
                .info("Đây là thông tin của Vũ")
                .build());
        users.add(userBuilder.id(3)
                .image(R.drawable.kimmese)
                .name("Kimmese")
                .info("Đây là thông tin của Kimmese")
                .build());
        users.add(userBuilder.id(4)
                .image(R.drawable.linhcao)
                .name("Linh Cáo")
                .info("Đây là thông tin của Linh Cáo")
                .build());
        users.add(userBuilder.id(5)
                .image(R.drawable.lynklee)
                .name("Lynk Lee")
                .info("Đây là thông tin của Lynk Lee")
                .build());
        users.add(userBuilder.id(6)
                .image(R.drawable.ngot)
                .name("Ngọt Band")
                .info("Đây là thông tin của Ngọt Band")
                .build());
        users.add(userBuilder.id(7)
                .image(R.drawable.maunuoc)
                .name("Màu nước Band")
                .info("Đây là thông tin của Màu nước Band")
                .build());
        users.add(userBuilder.id(8)
                .image(R.drawable.avt)
                .name("Truyền Lê")
                .info("Đây là thông tin của Truyền Lê")
                .build());
        return users;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            listener = (onClickFragmentInterface) context;
        else
            throw new RuntimeException(context.toString() + " must implement onViewSelected!");
    }

    @Override
    public void onClick(int position) {
        listener.onClickHomeFragment(userList.get(position));
    }
}