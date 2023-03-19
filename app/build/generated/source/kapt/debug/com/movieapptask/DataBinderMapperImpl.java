package com.movieapptask;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.movieapptask.databinding.ActivityFavouriteBindingImpl;
import com.movieapptask.databinding.ActivityMainBindingImpl;
import com.movieapptask.databinding.ActivityMovieDetailsBindingImpl;
import com.movieapptask.databinding.ActivitySearchBindingImpl;
import com.movieapptask.databinding.ActivitySplashBindingImpl;
import com.movieapptask.databinding.ItemCategoryBindingImpl;
import com.movieapptask.databinding.ItemGenreRowBindingImpl;
import com.movieapptask.databinding.ItemMovieRowBindingImpl;
import com.movieapptask.databinding.ToolbarBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYFAVOURITE = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_ACTIVITYMOVIEDETAILS = 3;

  private static final int LAYOUT_ACTIVITYSEARCH = 4;

  private static final int LAYOUT_ACTIVITYSPLASH = 5;

  private static final int LAYOUT_ITEMCATEGORY = 6;

  private static final int LAYOUT_ITEMGENREROW = 7;

  private static final int LAYOUT_ITEMMOVIEROW = 8;

  private static final int LAYOUT_TOOLBAR = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.activity_favourite, LAYOUT_ACTIVITYFAVOURITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.activity_movie_details, LAYOUT_ACTIVITYMOVIEDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.activity_search, LAYOUT_ACTIVITYSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.item_category, LAYOUT_ITEMCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.item_genre_row, LAYOUT_ITEMGENREROW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.item_movie_row, LAYOUT_ITEMMOVIEROW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movieapptask.R.layout.toolbar, LAYOUT_TOOLBAR);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYFAVOURITE: {
          if ("layout/activity_favourite_0".equals(tag)) {
            return new ActivityFavouriteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_favourite is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMOVIEDETAILS: {
          if ("layout/activity_movie_details_0".equals(tag)) {
            return new ActivityMovieDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_movie_details is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCH: {
          if ("layout/activity_search_0".equals(tag)) {
            return new ActivitySearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASH: {
          if ("layout/activity_splash_0".equals(tag)) {
            return new ActivitySplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCATEGORY: {
          if ("layout/item_category_0".equals(tag)) {
            return new ItemCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_category is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMGENREROW: {
          if ("layout/item_genre_row_0".equals(tag)) {
            return new ItemGenreRowBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_genre_row is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMMOVIEROW: {
          if ("layout/item_movie_row_0".equals(tag)) {
            return new ItemMovieRowBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_movie_row is invalid. Received: " + tag);
        }
        case  LAYOUT_TOOLBAR: {
          if ("layout/toolbar_0".equals(tag)) {
            return new ToolbarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for toolbar is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "fav");
      sKeys.put(2, "lang");
      sKeys.put(3, "model");
      sKeys.put(4, "title");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(9);

    static {
      sKeys.put("layout/activity_favourite_0", com.movieapptask.R.layout.activity_favourite);
      sKeys.put("layout/activity_main_0", com.movieapptask.R.layout.activity_main);
      sKeys.put("layout/activity_movie_details_0", com.movieapptask.R.layout.activity_movie_details);
      sKeys.put("layout/activity_search_0", com.movieapptask.R.layout.activity_search);
      sKeys.put("layout/activity_splash_0", com.movieapptask.R.layout.activity_splash);
      sKeys.put("layout/item_category_0", com.movieapptask.R.layout.item_category);
      sKeys.put("layout/item_genre_row_0", com.movieapptask.R.layout.item_genre_row);
      sKeys.put("layout/item_movie_row_0", com.movieapptask.R.layout.item_movie_row);
      sKeys.put("layout/toolbar_0", com.movieapptask.R.layout.toolbar);
    }
  }
}
