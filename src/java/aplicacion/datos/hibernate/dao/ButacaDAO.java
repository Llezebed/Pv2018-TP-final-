/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Butaca;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface ButacaDAO {
    ArrayList<Butaca> obtenerTodos();
    Butaca consulta(String butIde);
    void modificar (Butaca unaButaca);
    void agregar (Butaca unaButaca);
    void eliminar (Butaca unaButaca);
}
