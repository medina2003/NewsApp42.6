package kg.geektech.newsapp42.ui.profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.newsapp42.R;
import kg.geektech.newsapp42.databinding.FragmentImageBinding;

public class ImageFragment extends Fragment {
    private FragmentImageBinding binding;
    private ActivityResultLauncher <String> addPhoto;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentImageBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();

    }
//
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getImage();
    }
    private void getImage() {
        addPhoto=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                binding.imageview.setImageURI(result);
            }
        });

        binding.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPhoto.launch("image/*");//Филтер
            }
        });
    }
}