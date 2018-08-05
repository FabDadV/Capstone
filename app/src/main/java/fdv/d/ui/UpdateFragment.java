package fdv.d.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fdv.d.R;
// A placeholder fragment containing a simple view.
public class UpdateFragment extends Fragment {

    public UpdateFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.update_fragment, container, false);
    }
}
