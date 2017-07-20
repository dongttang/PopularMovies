package com.example.android.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.RecyclerViewClickListener {

    RecyclerView movieListRecyclerView;
    MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        movieListAdapter = new MovieListAdapter(this);

        movieListRecyclerView = (RecyclerView) findViewById(R.id.rv_movie_list);
        movieListRecyclerView.setLayoutManager(layoutManager);
        movieListRecyclerView.setHasFixedSize(true);

        loadPage();

    }

    @Override
    public void onListClick(int position) {

//        Intent intent = new Intent(this, MovieDetailActivity.class);
//        intent.putExtra("movieInfo", movieListAdapter.getMovieInfoList()[position]);
//        startActivity(intent);

        Toast.makeText(this, position + "is clicked!", Toast.LENGTH_SHORT).show();

    }

    void loadPage() {

        movieListAdapter.setMovieInfoList(null);
        new MovieInfoRequestTask(movieListAdapter).execute("aaa");
        movieListRecyclerView.setAdapter(movieListAdapter);

    }

}

// MainActivity
// TODO (1) 리스트뷰 클릭했을때 반응 없는 이슈 해결하기
// TODO (2) 임시 데이터 말고 API적용해서 실제 자료 가져오기
// TODO (3) 가져온 데이터중에 포스터 url 참고,
// TODO (4) 레이아웃 그리드뷰 말고 피카소 라이브러리 적용해서 바꾸기
// TODO (5) 메뉴바 달고 정렬 순서 고르는 버튼 추가 + 구현
// TODO (6) polishing
// TODO (7) 메뉴바 색깔 바꾸기

// MovieDetailActivity
// TODO (1) 레이아웃 꾸미기
// TODO (2) 가져온 가져온 데이터 배치

// +a
// TODO (1) 위로 당기면 새로고침
