/**
 * 
 */
package softhair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.HibernateException;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import softhair.model.Cliente;
import softhair.model.Funcionario;
import softhair.model.HorarioReservado;
import softhair.model.dao.ClienteDao;
import softhair.model.dao.FuncionarioDao;
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

	private ScheduleModel eventModel;
	private DefaultScheduleEvent event;

	private HorarioReservado horarioReservado;

	private List<HorarioReservado> horariosReservados;
	private HorarioReservadoDao horarioReservadoDao;

	private FuncionarioDao funcionarioDao;
	private List<Funcionario> funcionarios;
	private ClienteDao clienteDao;
	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		horarioReservadoDao = new HorarioReservadoDao();
		horarioReservado = new HorarioReservado();
		eventModel = new DefaultScheduleModel();
		horariosReservados = new ArrayList<HorarioReservado>();
		funcionarioDao = new FuncionarioDao();
		clienteDao = new ClienteDao();

		funcionarios = funcionarioDao.buscar();
		clientes = clienteDao.buscar();

		try {
			horariosReservados = horarioReservadoDao.buscar();

		} catch (HibernateException ex) {
			ex.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro no sql."));
		}

		if (!horariosReservados.isEmpty()) {
			for (HorarioReservado hr : horariosReservados) {
				DefaultScheduleEvent evt = new DefaultScheduleEvent();
				evt.setData(hr.getIdHorarioReservado());
				evt.setEndDate(hr.getDataFim().getTime());
				evt.setStartDate(hr.getDataInicio().getTime());
				evt.setTitle(hr.getCliente().getNome() + " - " + hr.getFuncionario().getNome());
				evt.setDescription(hr.getDescricao());
				evt.setAllDay(false);
				evt.setEditable(true);
				eventModel.addEvent(evt);
			}
		}
	}

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}
	
	public void dateSelect(SelectEvent  evt){
		horarioReservado.setDataFim((Calendar)evt.getObject());
		
	}
	
	public void addEvent(ActionEvent actionEvent) {
		event.setStartDate(horarioReservado.getDataInicio().getTime());
		event.setEndDate(horarioReservado.getDataFim().getTime());
		event.setTitle(horarioReservado.getCliente().getNome() + " - " + horarioReservado.getFuncionario().getNome());
		if (event.getId() == null) {
			horarioReservadoDao.salvar(horarioReservado);
			event.setData(horarioReservado.getIdHorarioReservado());
			eventModel.addEvent(event);
		} else {
			horarioReservadoDao.atualizar(horarioReservado);
			eventModel.updateEvent(event);
		}
		event = new DefaultScheduleEvent();
	}
	
	public void desmarcar(){
		horarioReservadoDao.deletar(horarioReservado);
		eventModel.deleteEvent(event);
		
	}
	
	public void onEventSelect(SelectEvent selectEvent) {
		event = (DefaultScheduleEvent) selectEvent.getObject();
		horarioReservado = horarioReservadoDao.buscar((Integer) event.getData());
	}

	public void onDateSelect(SelectEvent selectEvent) {
		// Ao selecionar uma data, cria uma nova instância do HR, setando por
		// padrão a data selecionada no scheduler.
		horarioReservado = new HorarioReservado();
		Calendar calendar = Calendar.getInstance(new Locale("PT", "BR"));
		calendar.setTime((Date) selectEvent.getObject());

		horarioReservado.setDataInicio(calendar);
		horarioReservado.setDataFim(calendar);
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	// Métodos de acesso

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

	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios
	 *            the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes
	 *            the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(DefaultScheduleEvent event) {
		this.event = event;
	}

}
