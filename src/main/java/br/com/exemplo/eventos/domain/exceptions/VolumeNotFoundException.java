package br.com.exemplo.eventos.domain.exceptions;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

public class VolumeNotFoundException extends Exception {

    public VolumeNotFoundException () {
        super("Volume não encontrado");
    }

}
