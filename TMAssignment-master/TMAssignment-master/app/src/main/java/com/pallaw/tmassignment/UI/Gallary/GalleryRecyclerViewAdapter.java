package com.pallaw.tmassignment.UI.Gallary;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pallaw.tmassignment.Data.Models.CompatibilityQuestionsBean;
import com.pallaw.tmassignment.R;

import java.util.List;

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.ViewHolder> {

    private FragmentActivity context;
    private final List<CompatibilityQuestionsBean> mValues;
    private DisplayMode displayMode;

    public GalleryRecyclerViewAdapter(FragmentActivity context, List<CompatibilityQuestionsBean> items, DisplayMode displayMode) {
        this.context = context;
        mValues = items;
        this.displayMode = displayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.displayMode = displayMode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (displayMode) {
            case LIST:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_gallery_item_list, parent, false);
                break;
            case GRID:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_gallery_item_grid, parent, false);
                break;
            case CAROUSEL:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_gallery_item_carousel, parent, false);
                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final AppCompatImageView img;
        public final TextView title;
        public CompatibilityQuestionsBean mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            img =(AppCompatImageView) view.findViewById(R.id.img_view);
            title =(TextView) view.findViewById(R.id.title);
        }

        public void bindData(CompatibilityQuestionsBean compatibilityQuestionsBean) {
            setImage(compatibilityQuestionsBean, img);
            title.setText(String.valueOf(compatibilityQuestionsBean.question));
        }

        private void setImage(CompatibilityQuestionsBean questionsBean, AppCompatImageView img) {
            int screenSize = context.getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK;
            String questionsImage;
            switch(screenSize) {
                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    questionsImage = questionsBean.style.large;
                    break;
                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    questionsImage = questionsBean.style.medium;
                    break;
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    questionsImage = questionsBean.style.thumb;
                    break;
                default:
                    questionsImage = questionsBean.style.original;

            }

            Glide.with(context).
                    load(questionsImage)
                    .into(img);
        }
    }
}
