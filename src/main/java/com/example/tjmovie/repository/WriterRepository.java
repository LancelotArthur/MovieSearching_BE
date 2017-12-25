package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Writer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WriterRepository extends CrudRepository<Writer, String> {

    /**
     * @param writer 要存储的writer
     * @return 返回已经存储在数据库的Writer
     */
    Writer save(Writer writer);

    List<Writer> findWritersByCbId(String cbId);

    List<Writer> findWritersByMovieId(String movieId);

}
