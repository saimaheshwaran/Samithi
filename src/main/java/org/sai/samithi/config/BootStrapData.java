package org.sai.samithi.config;

import org.sai.samithi.entities.Home;
import org.sai.samithi.entities.Post;
import org.sai.samithi.services.HomeService;
import org.sai.samithi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    HomeService homeService;

    @Autowired
    PostService postService;

    @Override
    public void run(String... args) throws Exception {
        //loadPostsEntities();
    }

    void loadHomeEntities() {
        Home home = new Home();
        home.setPairKey("carousel-1");
        home.setPairValue("https://www.youtube.com/embed/l2PCtFSrca8?si=dGumiIRR8jLVc42j");
        homeService.add(home);

        home = new Home();
        home.setPairKey("carousel-2");
        home.setPairValue("https://www.youtube.com/embed/JIZwA_-95hw?si=U1q7xCh7MI_oZQB7");
        homeService.add(home);

        home = new Home();
        home.setPairKey("carousel-3");
        home.setPairValue("https://www.youtube.com/embed/gfKy4UsahoQ?si=8qeBKL0mcbE_yHgH");
        homeService.add(home);
    }

    void loadPostsEntities() {
        Post post = new Post();
        post.setName("shiva");
        post.setDescription("Celebration of NavaShivathri");
        post.setUrl("shiva");
        postService.add(post);

        post = new Post();
        post.setName("AsthaRathri");
        post.setDescription("Celebration of AsthaRathri");
        post.setUrl("durgi");
        postService.add(post);

        post = new Post();
        post.setName("Aditya");
        post.setDescription("Celebration of Sankranthi");
        post.setUrl("surya");
        postService.add(post);
    }
}
