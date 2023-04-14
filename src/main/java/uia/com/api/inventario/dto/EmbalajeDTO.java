package uia.com.api.inventario.dto;


public class EmbalajeDTO extends ItemDTO {
        //private List<Lote> lotes = new ArrayList<Lote>();

        public EmbalajeDTO() {
        }

        public EmbalajeDTO(String id, String name, String descripcion, String estatus, String clase)
        {
            super(id, name, descripcion, estatus, clase);
        }


}
