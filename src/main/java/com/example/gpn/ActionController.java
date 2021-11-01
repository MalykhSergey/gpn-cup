package com.example.gpn;

import com.example.gpn.wsdl.AddResponse;
import com.example.gpn.wsdl.DivideResponse;
import com.example.gpn.wsdl.MultiplyResponse;
import com.example.gpn.wsdl.SubtractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ActionController {
    ConcurrentHashMap<Nums, Integer> addCache;
    ConcurrentHashMap<Nums, Integer> divideCache;
    ConcurrentHashMap<Nums, Integer> multiplyCache;
    ConcurrentHashMap<Nums, Integer> subtractCache;
    ActionService actionService;

    @Autowired
    public ActionController(
            @Qualifier("AddCache") ConcurrentHashMap<Nums, Integer> addCache,
            @Qualifier("DivideCache") ConcurrentHashMap<Nums, Integer> divideCache,
            @Qualifier("MultiplyCache") ConcurrentHashMap<Nums, Integer> multiplyCache,
            @Qualifier("SubtractCache") ConcurrentHashMap<Nums, Integer> subtractCache,
            ActionService actionService) {
        this.addCache = addCache;
        this.divideCache = divideCache;
        this.multiplyCache = multiplyCache;
        this.subtractCache = subtractCache;
        this.actionService = actionService;
    }

    @ResponseBody
    @PostMapping("/add")
    public int add(@RequestBody Nums nums) {
        if (!addCache.containsKey(nums)) {
            AddResponse addResponse = actionService.addNums(Integer.parseInt(nums.intA), Integer.parseInt(nums.intB));
            addCache.put(nums, addResponse.getAddResult());
            return addResponse.getAddResult();
        } else return addCache.get(nums);
    }

    @PostMapping("/subtract")
    public Integer subtract(@RequestBody Nums nums) {
        if (!subtractCache.containsKey(nums)) {
            SubtractResponse subtractResponse = actionService.subtractNums(Integer.parseInt(nums.intA), Integer.parseInt(nums.intB));
            subtractCache.put(nums, subtractResponse.getSubtractResult());
            return subtractResponse.getSubtractResult();
        } else return subtractCache.get(nums);
    }

    @PostMapping("/divide")
    public Integer divide(@RequestBody Nums nums) {
        if (!divideCache.containsKey(nums)) {
            DivideResponse divideResponse = actionService.divideNums(Integer.parseInt(nums.intA), Integer.parseInt(nums.intB));
            divideCache.put(nums, divideResponse.getDivideResult());
            return divideResponse.getDivideResult();
        } else return divideCache.get(nums);
    }

    @PostMapping("/multiply")
    public Integer multiply(@RequestBody Nums nums) {
        if (!multiplyCache.containsKey(nums)) {
            MultiplyResponse multiplyResponse = actionService.multiplyNums(Integer.parseInt(nums.intA), Integer.parseInt(nums.intB));
            multiplyCache.put(nums, multiplyResponse.getMultiplyResult());
            return multiplyResponse.getMultiplyResult();
        } else return multiplyCache.get(nums);
    }
}
