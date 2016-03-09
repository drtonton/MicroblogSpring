package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by noellemachin on 3/9/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
