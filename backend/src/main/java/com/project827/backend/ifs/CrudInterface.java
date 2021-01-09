package com.project827.backend.ifs;

import com.project827.backend.model.network.Header;

public interface CrudInterface<Req,Res> {

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
    
}