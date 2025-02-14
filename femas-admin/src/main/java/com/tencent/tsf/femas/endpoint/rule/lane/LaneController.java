package com.tencent.tsf.femas.endpoint.rule.lane;

import com.tencent.tsf.femas.common.util.Result;
import com.tencent.tsf.femas.endpoint.adaptor.AbstractBaseEndpoint;
import com.tencent.tsf.femas.entity.PageService;
import com.tencent.tsf.femas.entity.rule.lane.LaneInfo;
import com.tencent.tsf.femas.entity.rule.lane.LaneInfoModel;
import com.tencent.tsf.femas.entity.rule.lane.LaneRule;
import com.tencent.tsf.femas.entity.rule.lane.LaneRuleModel;
import com.tencent.tsf.femas.service.rule.LaneService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: cody
 * @Date: 2022/7/26/17:04
 * @Descriptioin
 */
@RestController
@RequestMapping("atom/v1//lane")
@Api(tags = "泳道配置模块")
public class LaneController extends AbstractBaseEndpoint {


    @Autowired
    LaneService laneService;

    @RequestMapping(value = "/configureLane", method = RequestMethod.POST)
    public Result configureLane(@RequestBody LaneInfo laneInfo) {
        return executor.process(()->laneService.configureLane(laneInfo));
    }

    @RequestMapping(value = "/fetchLaneById", method = RequestMethod.POST)
    public Result<LaneInfo> fetchLaneById(@RequestBody String laneId) {
        return executor.process(()->laneService.fetchLaneById(laneId));
    }

    @RequestMapping(value = "/fetchLaneInfoPages", method = RequestMethod.POST)
    public Result<PageService<LaneInfo>> fetchLaneInfoPages(@RequestBody LaneInfoModel laneInfoModel) {
        return executor.process(()->laneService.fetchLaneInfoPages(laneInfoModel));
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result deleteLane(@RequestBody String laneId) {
        return executor.process(()->laneService.deleteLane(laneId));
    }


    @RequestMapping(value = "/rule/configureLaneRule", method = RequestMethod.POST)
    public Result createLaneRule(@RequestBody LaneRule laneRule) {
        return executor.process(()->laneService.configureLaneRule(laneRule));
    }

    @RequestMapping(value = "/rule/fetchLaneRuleById", method = RequestMethod.POST)
    public Result<LaneRule> fetchLaneRuleById(@RequestBody String laneRuleId) {
        return executor.process(()->laneService.fetchLaneRuleById(laneRuleId));
    }

    @RequestMapping(value = "/rule/fetchLaneRulePages", method = RequestMethod.POST)
    public Result<PageService<LaneRule>> fetchLaneRulePages(@RequestBody LaneRuleModel laneRuleModel) {
        return executor.process(()->laneService.fetchLaneRulePages(laneRuleModel));
    }

    @RequestMapping(value = "/rule/delete", method = RequestMethod.POST)
    public Result deleteRule(@RequestBody String laneRuleId) {
        return executor.process(()->laneService.deleteLaneRule(laneRuleId));
    }

}
