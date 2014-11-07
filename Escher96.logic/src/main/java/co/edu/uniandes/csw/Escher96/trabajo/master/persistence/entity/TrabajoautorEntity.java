/* ========================================================================
 * Copyright 2014 Escher96
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 Escher96

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201410152247

*/

package co.edu.uniandes.csw.Escher96.trabajo.master.persistence.entity;

import co.edu.uniandes.csw.Escher96.autor.persistence.entity.AutorEntity;
import co.edu.uniandes.csw.Escher96.trabajo.persistence.entity.TrabajoEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(TrabajoautorEntityId.class)
@NamedQueries({
    @NamedQuery(name = "TrabajoautorEntity.getByMasterId", query = "SELECT  u FROM TrabajoautorEntity u WHERE u.trabajoId=:trabajoId"),
    @NamedQuery(name = "TrabajoautorEntity.deleteTrabajoautorEntity", query = "DELETE FROM TrabajoautorEntity u WHERE u.trabajoId=:trabajoId and  u.autorId=:autorId")
})
public class TrabajoautorEntity implements Serializable {

    @Id
    @Column(name = "trabajoId")
    private Long trabajoId;
    @Id
    @Column(name = "autorId")
    private Long autorId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "trabajoId", referencedColumnName = "id")
    @JoinFetch
    private AutorEntity trabajoIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "autorId", referencedColumnName = "id")
    @JoinFetch
    private AutorEntity autorIdEntity; 

    public TrabajoautorEntity() {
    }

    public TrabajoautorEntity(Long trabajoId, Long autorId) {
        this.trabajoId =trabajoId;
        this.autorId = autorId;
    }

    public Long getTrabajoId() {
        return trabajoId;
    }

    public void setTrabajoId(Long trabajoId) {
        this.trabajoId = trabajoId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public AutorEntity getTrabajoIdEntity() {
        return trabajoIdEntity;
    }

    public void setTrabajoIdEntity(AutorEntity trabajoIdEntity) {
        this.trabajoIdEntity = trabajoIdEntity;
    }

    public AutorEntity getAutorIdEntity() {
        return autorIdEntity;
    }

    public void setAutorIdEntity(AutorEntity autorIdEntity) {
        this.autorIdEntity = autorIdEntity;
    }

}