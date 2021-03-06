// Generated by view binder compiler. Do not edit!
package com.example.premiertry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.premiertry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttoncancel;

  @NonNull
  public final ImageView emojiurgence;

  @NonNull
  public final ImageView emojiwiouwoug;

  @NonNull
  public final TextView textView18;

  @NonNull
  public final TextView textsos;

  @NonNull
  public final TextView titlesos;

  private ActivitySosBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttoncancel,
      @NonNull ImageView emojiurgence, @NonNull ImageView emojiwiouwoug,
      @NonNull TextView textView18, @NonNull TextView textsos, @NonNull TextView titlesos) {
    this.rootView = rootView;
    this.buttoncancel = buttoncancel;
    this.emojiurgence = emojiurgence;
    this.emojiwiouwoug = emojiwiouwoug;
    this.textView18 = textView18;
    this.textsos = textsos;
    this.titlesos = titlesos;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttoncancel;
      Button buttoncancel = ViewBindings.findChildViewById(rootView, id);
      if (buttoncancel == null) {
        break missingId;
      }

      id = R.id.emojiurgence;
      ImageView emojiurgence = ViewBindings.findChildViewById(rootView, id);
      if (emojiurgence == null) {
        break missingId;
      }

      id = R.id.emojiwiouwoug;
      ImageView emojiwiouwoug = ViewBindings.findChildViewById(rootView, id);
      if (emojiwiouwoug == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = ViewBindings.findChildViewById(rootView, id);
      if (textView18 == null) {
        break missingId;
      }

      id = R.id.textsos;
      TextView textsos = ViewBindings.findChildViewById(rootView, id);
      if (textsos == null) {
        break missingId;
      }

      id = R.id.titlesos;
      TextView titlesos = ViewBindings.findChildViewById(rootView, id);
      if (titlesos == null) {
        break missingId;
      }

      return new ActivitySosBinding((ConstraintLayout) rootView, buttoncancel, emojiurgence,
          emojiwiouwoug, textView18, textsos, titlesos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
