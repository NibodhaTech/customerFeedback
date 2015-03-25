package com.travel.customerFeedback.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.travel.customerFeedback.dao.CommentRepository;
import com.travel.customerFeedback.dao.GenieRepository;
import com.travel.customerFeedback.dao.GenieStatusTypeRepository;
import com.travel.customerFeedback.dao.UserRepository;
import com.travel.customerFeedback.entity.Comment;
import com.travel.customerFeedback.entity.Genie;
import com.travel.customerFeedback.model.BookingDetailModel;
import com.travel.customerFeedback.model.CommentModel;
import com.travel.customerFeedback.model.GenieModel;

@Service
public class FeedbackService {

	@Autowired GenieRepository genieRepository;
	
	@Autowired UserRepository userRepository;
	
	@Autowired NLPService nlpService;
	@Autowired UserAssignmentService userAssignmentService;
	
	@Autowired CommentRepository commentRepository;
	
	@Autowired GenieStatusTypeRepository genieStatusTypeRepository;
	
	
	public GenieModel createGenie(GenieModel genieModel){
		Genie genie = this.convertToGenie(genieModel);
		genie = genieRepository.save(genie);
		genieModel.setId(genie.getId());
		return genieModel;
	}
	
	public GenieModel updateGenie(GenieModel genieModel){
		Genie genie = this.convertToGenie(genieModel);
		genie = genieRepository.save(genie);
		genieModel.setId(genie.getId());
		return genieModel;
	}
	
	public CommentModel updateComments(CommentModel commentModel) {
		Comment persistedComment=commentRepository.save(this.convertToComment(commentModel));
		commentModel.setId(persistedComment.getId());
		return commentModel;
		
	}
	
	public GenieModel getGenieByGenieId(long genieId) {
		Genie genie=genieRepository.findOne(genieId);
		List<Comment> listComment=commentRepository.findAllByGenieId(genieId);
		List<CommentModel> listCommentModel=new ArrayList<CommentModel>();
		for(Comment comment:listComment){
			listCommentModel.add(this.convertToCommentModel(comment));
		}
		GenieModel genieModel=this.convertToGenieModel(genie);
		genieModel.setListCommentModel(listCommentModel);
		return genieModel;
	}
	
	public List<GenieModel> getAllGenieByUserId(long userId){
		List<Genie> listGenie=genieRepository.findAllGenieByUserId(userId);
		List<GenieModel> listGenieModel=new ArrayList<GenieModel>();
		for(Genie genie:listGenie){
			listGenieModel.add(this.convertToGenieModel(genie));
		}
		return listGenieModel;
		
	}
	
	public List<GenieModel> getAllGenieByAssignedUserId(long assignedToUserId){
		List<Genie> listGenie=genieRepository.findAllGenieByAssignedToUserId(assignedToUserId);
		List<GenieModel> listGenieModel=new ArrayList<GenieModel>();
		for(Genie genie:listGenie){
			listGenieModel.add(this.convertToGenieModel(genie));
		}
		return listGenieModel;
		
	}
	
	public List<GenieModel> getAllGenieforSuperAdmin(){
		List<Genie> listGenie=genieRepository.findAll();
		List<GenieModel> listGenieModel=new ArrayList<GenieModel>();
		for(Genie genie:listGenie){
			listGenieModel.add(this.convertToGenieModel(genie));
		}
		return listGenieModel;
		
	}
	
	

	private Comment convertToComment(CommentModel commentModel){
		Comment comment=new Comment();
		comment.setCreatedDate(commentModel.getCreatedDate());
		comment.setDescription(commentModel.getDescription());
		comment.setGenieStatusType(genieStatusTypeRepository.findOne(commentModel.getGenieStatusId()));
		comment.setIsUser(commentModel.getIsUser());
		comment.setUserId(commentModel.getUserProfileId());
		return comment;
	}
	
	private CommentModel convertToCommentModel(Comment comment){
		CommentModel commentModel=new CommentModel();
		commentModel.setCreatedDate(comment.getCreatedDate());
		commentModel.setDescription(comment.getDescription());
		commentModel.setGenieStatusId(comment.getGenieStatusType().getId());
		commentModel.setIsUser(comment.getIsUser());
		commentModel.setUserProfileId(comment.getUserId());
		return commentModel;
	}
	private Genie convertToGenie(GenieModel genieModel) {
		Genie genie = new Genie();
		if(genieModel.getCreatedDate()!=null){
			genie.setCreatedDate(genieModel.getCreatedDate());
		}
		if(StringUtils.isNotEmpty(genieModel.getDescription())){
			genie.setDescription(genieModel.getDescription());
			genie.setSentiment_score(nlpService.getFeedbackType(genieModel.getDescription()));
			genie.setAssignedToUserId(userAssignmentService.getToAssignUserId(genieModel.getDescription()));
		}
		
		if(StringUtils.isNotEmpty(genieModel.getDescription())){
			genie.setDocumentpath(genieModel.getDescription());
		}
		if(genieModel.getGenieStatusId()!=0.){
			genie.setGenieStatusType(genieStatusTypeRepository.findOne(genieModel.getGenieStatusId()));
		}
		if(StringUtils.isNotEmpty(genieModel.getPriority())){
			genie.setPriority(genieModel.getPriority());
		}
		if(StringUtils.isNotEmpty(genieModel.getRating())){
			genie.setRating(genieModel.getRating());
		}
			
		
		if(StringUtils.isNotEmpty(genieModel.getPhoneNumber())){
			genie.setUserId(userRepository.findOneByPhoneNo(genieModel.getPhoneNumber()).getId());
		}
	
		
		return genie;
	}
	
	private GenieModel convertToGenieModel(Genie genie) {
		GenieModel genieModel = new GenieModel();
		genieModel.setCreatedDate(genieModel.getCreatedDate());
		genieModel.setDescription(genieModel.getDescription());
		genieModel.setDocumentpath(genieModel.getDocumentpath());
		genieModel.setGenieStatusId(genieModel.getGenieStatusId());
		genieModel.setPriority(genieModel.getPriority());
		genieModel.setRating(genieModel.getRating());
		genieModel.setSentiment_score(genieModel.getSentiment_score());
		genieModel.setUserId(genieModel.getUserId());
		return genieModel;
	}


}
