// Generated by view binder compiler. Do not edit!
package com.example.squidarcade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.squidarcade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRlglSingleplayerBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button buttonStart;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  private FragmentRlglSingleplayerBinding(@NonNull FrameLayout rootView,
      @NonNull Button buttonStart, @NonNull ImageView imageView3, @NonNull ImageView imageView4) {
    this.rootView = rootView;
    this.buttonStart = buttonStart;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRlglSingleplayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRlglSingleplayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_rlgl_singleplayer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRlglSingleplayerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonStart;
      Button buttonStart = ViewBindings.findChildViewById(rootView, id);
      if (buttonStart == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      return new FragmentRlglSingleplayerBinding((FrameLayout) rootView, buttonStart, imageView3,
          imageView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
