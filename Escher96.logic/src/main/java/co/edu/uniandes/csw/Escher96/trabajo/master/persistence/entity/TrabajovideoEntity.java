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

import co.edu.uniandes.csw.Escher96.video.persistence.entity.VideoEntity;
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
@IdClass(TrabajovideoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "TrabajovideoEntity.getByMasterId", query = "SELECT  u FROM TrabajovideoEntity u WHERE u.trabajoId=:trabajoId"),
    @NamedQuery(name = "TrabajovideoEntity.deleteTrabajovideoEntity", query = "DELETE FROM TrabajovideoEntity u WHERE u.trabajoId=:trabajoId and  u.videoId=:videoId")
})
public class TrabajovideoEntity implements Serializable {

    @Id
    @Column(name = "trabajoId")
    private Long trabajoId;
    @Id
    @Column(name = "videoId")
    private Long videoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "trabajoId", referencedColumnName = "id")
    @JoinFetch
    private VideoEntity trabajoIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "videoId", referencedColumnName = "id")
    @JoinFetch
    private VideoEntity videoIdEntity; 

    public TrabajovideoEntity() {
    }

    public TrabajovideoEntity(Long trabajoId, Long videoId) {
        this.trabajoId =trabajoId;
        this.videoId = videoId;
    }

    public Long getTrabajoId() {
        return trabajoId;
    }

    public void setTrabajoId(Long trabajoId) {
        this.trabajoId = trabajoId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public VideoEntity getTrabajoIdEntity() {
        return trabajoIdEntity;
    }

    public void setTrabajoIdEntity(VideoEntity trabajoIdEntity) {
        this.trabajoIdEntity = trabajoIdEntity;
    }

    public VideoEntity getVideoIdEntity() {
        return videoIdEntity;
    }

    public void setVideoIdEntity(VideoEntity videoIdEntity) {
        this.videoIdEntity = videoIdEntity;
    }

}
