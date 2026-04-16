package org.domain.article;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.Article;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ArticleFileRepository extends ArticleRepository {
    private static final String DB_DIR = "db";
    private final ObjectMapper mapper = new ObjectMapper();
    private int lastId;

    public ArticleFileRepository() {
        new File(DB_DIR).mkdirs();
        lastId = loadLastId();
    }

    @Override
    public Article save(Article article) {
        article.setId(++lastId);
        writeToFile(article);
        return article;
    }

    @Override
    public Article update(Article article) {
        writeToFile(article);
        return article;
    }

    @Override
    public void delete(Article article) {
        new File(DB_DIR + "/" + article.getId() + ".json").delete();
    }

    @Override
    public List<Article> findAll() {
        return loadAll();
    }

    @Override
    public Article findById(int id) {
        File file = new File(DB_DIR + "/" + id + ".json");
        if (!file.exists()) return null;
        return readFromFile(file);
    }

    @Override
    public List<Article> findByKeyword(String keyword) {
        return loadAll().stream()
                .filter(a -> a.getTitle().contains(keyword) || a.getContent().contains(keyword))
                .toList();
    }

    private int loadLastId() {
        File dir = new File(DB_DIR);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        if (files == null || files.length == 0) return 0;
        int max = 0;
        for (File f : files) {
            try {
                int id = Integer.parseInt(f.getName().replace(".json", ""));
                if (id > max) max = id;
            } catch (NumberFormatException ignored) {}
        }
        return max;
    }

    private void writeToFile(Article article) {
        try {
            ObjectNode node = mapper.createObjectNode();
            node.put("id", article.getId());
            node.put("title", article.getTitle());
            node.put("content", article.getContent());
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(DB_DIR + "/" + article.getId() + ".json"), node);
        } catch (IOException e) {
            System.out.println("저장 실패: " + e.getMessage());
        }
    }

    private Article readFromFile(File file) {
        try {
            JsonNode node = mapper.readTree(file);
            int id = node.get("id").asInt();
            String title = node.get("title").asText();
            String content = node.get("content").asText();
            Article article = new Article(title, content);
            article.setId(id);
            return article;
        } catch (IOException e) {
            System.out.println("읽기 실패: " + e.getMessage());
            return null;
        }
    }

    private List<Article> loadAll() {
        File dir = new File(DB_DIR);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        if (files == null) return List.of();
        return Arrays.stream(files)
                .map(this::readFromFile)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(Article::getId).reversed())
                .toList();
    }
}
