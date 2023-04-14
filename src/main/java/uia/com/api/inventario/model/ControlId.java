package uia.com.api.inventario.model;

import uia.com.api.inventario.dto.PartidaDTO;

public class ControlId extends InfoItem{
    private String index="";
    private String idPartida;
    private String idSubpartida;
    private String idCategoria;
    private String idLote;
    private String idItem;
    private String idProveedor;
    private String nameSubpartida;

    public ControlId() {
    }

    public ControlId(String clase, String idCategoria, String nameCategoria, String idPartida, String namePartida, String idSubpartida, String nameSubpartida, String idProveedor, String index)
    {
        super(clase, idCategoria, nameCategoria, "sinEstatus", "1", "");

    }

    public ControlId(Partida entityPartida)
    {
        super();
        this.idPartida = entityPartida.getIdPartida() + "-" + entityPartida.getName();
        this.idSubpartida = entityPartida.getIdSubpartida() + "-" + entityPartida.getNameSubpartida();
        this.idCategoria = entityPartida.getIdCategoria() + "-" + entityPartida.getNameCategoria();
        this.idLote =  entityPartida.getIdProveedor()+"-"+entityPartida.getIdPartida() + "-" + entityPartida.getIdSubpartida() + "-" + entityPartida.getIdCategoria();
        this.idItem =  entityPartida.getIdProveedor()+"-"+entityPartida.getIdCategoria() + "-" + this.index + entityPartida.getNameSubpartida();
        this.idProveedor = entityPartida.getIdProveedor();
        this.nameSubpartida = entityPartida.getNameSubpartida();
    }

    public ControlId(PartidaDTO partidaDTO)
    {
        this.idPartida = partidaDTO.getIdPartida() + "-" + partidaDTO.getNamePartida();
        this.idSubpartida = partidaDTO.getIdSubpartida() + "-" + partidaDTO.getNameSubpartida();
        this.idCategoria = partidaDTO.getIdCategoria() + "-" + partidaDTO.getNameCategoria();
        this.idLote =  partidaDTO.getIdProveedor()+"-"+partidaDTO.getIdPartida() + "-" + partidaDTO.getIdSubpartida() + "-" + partidaDTO.getIdCategoria();
        this.idItem =  partidaDTO.getIdProveedor()+"-"+partidaDTO.getIdCategoria() + "-" + this.index + partidaDTO.getNameSubpartida();
        this.idProveedor = partidaDTO.getIdProveedor();
        this.nameSubpartida = partidaDTO.getNameSubpartida();
    }

    public void setId()
    {
            this.idPartida = this.getIdPartida() + "-" + this.getNamePartida();
            this.idSubpartida = this.getIdSubpartida() + "-" + this.getNameSubpartida();
            this.idCategoria = this.getIdCategoria() + "-" + this.getNameCategoria();
            this.idLote = this.idProveedor + "-" + this.getIdPartida() + "-" + this.getIdSubpartida() + "-" + this.getIdCategoria();
            this.idItem = this.idProveedor + "-" + this.getIdCategoria() + "-" + this.index + this.getNameSubpartida();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String getIdPartida() {
        return idPartida;
    }

    @Override
    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public String getIdSubpartida() {
        return idSubpartida;
    }

    @Override
    public void setIdSubpartida(String idSubpartida) {
        this.idSubpartida = idSubpartida;
    }

    @Override
    public String getIdCategoria() {
        return idCategoria;
    }

    @Override
    public void setIdCategoria(String idCategoria) {
        idCategoria = idCategoria;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        idLote = idLote;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        idItem = idItem;
    }

    public String getIdItem(int j)
    {
        this.index = String.valueOf(j);
        this.idItem = idProveedor + "-" + this.getIdCategoria() + "-" + this.index ;
        return this.idItem;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String getNameSubpartida() {
        return nameSubpartida;
    }

    @Override
    public void setNameSubpartida(String nameSubpartida) {
        this.nameSubpartida = nameSubpartida;
    }
}
