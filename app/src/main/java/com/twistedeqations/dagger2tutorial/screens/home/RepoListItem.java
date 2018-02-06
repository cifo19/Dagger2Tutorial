package com.twistedeqations.dagger2tutorial.screens.home;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.twistedeqations.dagger2tutorial.R;
import com.twistedeqations.dagger2tutorial.models.GithubRepo;
import com.twistedeqations.dagger2tutorial.screens.DetailActivity;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListItem extends FrameLayout {

    @BindView(R.id.user_avatar)
    ImageView avatarImage;

    @BindView(R.id.repo_name)
    TextView name;

    @BindView(R.id.repo_description)
    TextView description;

    @BindView(R.id.repo_stars)
    TextView stars;

    @BindView(R.id.repo_issues)
    TextView issues;

    @BindView(R.id.repo_forks)
    TextView forks;

    @BindView(R.id.repo_updated_at)
    TextView updatedAt;

    Picasso picasso;
    Context context;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.fullDate();

    public RepoListItem(Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
        this.context = context;
        inflate(getContext(), R.layout.list_item_repo, this);
        ButterKnife.bind(this);
    }

    public void setRepo(final GithubRepo githubRepo) {
        Locale locale = getResources().getConfiguration().locale;

        name.setText(githubRepo.name);
        description.setVisibility(TextUtils.isEmpty(githubRepo.description) ? GONE : VISIBLE);
        description.setText(githubRepo.description);

        stars.setText(String.format(locale, "%d", githubRepo.stargazersCount));
        issues.setText(String.format(locale, "%d", githubRepo.openIssuesCount));
        forks.setText(String.format(locale, "%d", githubRepo.forksCount));

        updatedAt.setText(getResources()
                .getString(R.string.last_pushed, DATE_TIME_FORMATTER.print(githubRepo.updatedAt)));

        picasso.load(githubRepo.owner.avatarUrl)
                .placeholder(R.drawable.ic_person_black_24dp)
                .into(avatarImage);

        avatarImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("owner", githubRepo.owner);
                context.startActivity(intent);
            }
        });
    }
}
