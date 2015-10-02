/**
 * 
 */
package softhair.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.ScheduleModel;

import softhair.model.HorarioReservado;
import softhair.model.dao.HorarioReservadoDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
@ManagedBean
@ViewScoped
public class AgendaController implements Serializable {

	private static final long serialVersionUID = 703608333071770327L;

	private HorarioReservado horarioReservado;
	private ScheduleModel horarioModel;
	private List<HorarioReservado> horariosReservados;
	private HorarioReservadoDao horarioReservadoDao;

	/**
	 * @return the horarioReservado
	 */
	public HorarioReservado getHorarioReservado() {
		return horarioReservado;
	}

	/**
	 * @param horarioReservado
	 *            the horarioReservado to set
	 */
	public void setHorarioReservado(HorarioReservado horarioReservado) {
		this.horarioReservado = horarioReservado;
	}

	/**
	 * @return the horarioModel
	 */
	public ScheduleModel getHorarioModel() {
		return horarioModel;
	}

	/**
	 * @param horarioModel
	 *            the horarioModel to set
	 */
	public void setHorarioModel(ScheduleModel horarioModel) {
		this.horarioModel = horarioModel;
	}

	/**
	 * @return the horariosReservados
	 */
	public List<HorarioReservado> getHorariosReservados() {
		return horariosReservados;
	}

	/**
	 * @param horariosReservados
	 *            the horariosReservados to set
	 */
	public void setHorariosReservados(List<HorarioReservado> horariosReservados) {
		this.horariosReservados = horariosReservados;
	}

	/**
	 * @return the horarioReservadoDao
	 */
	public HorarioReservadoDao getHorarioReservadoDao() {
		return horarioReservadoDao;
	}

	/**
	 * @param horarioReservadoDao
	 *            the horarioReservadoDao to set
	 */
	public void setHorarioReservadoDao(HorarioReservadoDao horarioReservadoDao) {
		this.horarioReservadoDao = horarioReservadoDao;
	}
	
	/*@PostConstruct
	public void inicializar(){
		horarioReservadoDao = new HorarioReservadoDao();
		horarioReservado = new HorarioReservado();
		horarioModel = new DefaultScheduleModel();
		
		try{
			horariosReservados = horarioReservadoDao.buscar();
			
		} catch (HibernateException ex){
			ex.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro no sql."));
		}
		
		for(HorarioReservado hr : horariosReservados){
			DefaultScheduleEvent evt = new DefaultScheduleEvent();
			evt.setEndDate(hr.getDataFim().toDate());
			evt.setStartDate(hr.getDataInicio().toDate());
			evt.setTitle(hr.getCliente().getNome() + " - " + hr.getFuncionario().getNome());
			evt.setData(hr.getIdHorarioReservado());
			evt.setDescription(hr.getDescricao());
			evt.setAllDay(true);
			evt.setEditable(true);
			
			horarioModel.addEvent(evt);
			
		}
	}
	
	public void onHorarioReservadoSelecionado(SelectEvent selectEvent){
		ScheduleEvent evento = (ScheduleEvent) selectEvent.getObject();
		
		for(HorarioReservado hr : horariosReservados){
			if(hr.getIdHorarioReservado() == (int) evento.getData()){
				horarioReservado = hr;
				break;
			}
		}
	}
	
	public void onHorarioReservadoNovo(SelectEvent selectEvent){
		ScheduleEvent evento = new DefaultScheduleEvent("",(Date)selectEvent.getObject(), (Date)selectEvent.getObject());
		horarioReservado = new HorarioReservado();
		horarioReservado.setDataInicio(new DateTime(evento.getStartDate()));
		horarioReservado.setDataFim(new DateTime(evento.getStartDate()));
	}*/
}